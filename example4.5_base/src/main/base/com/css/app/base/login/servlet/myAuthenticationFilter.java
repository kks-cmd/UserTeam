package com.css.app.base.login.servlet;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import com.css.restclient.impl.model.RestSUser;
import org.apache.commons.httpclient.HttpStatus;
import org.slw.framework.context.SlwContext;
import org.slw.sso.client.SsoClient;
import org.slw.sso.config.SsoConfig;
import org.slw.sso.user.SsoUser;
import org.slw.rest.exception.StatusException;

public class myAuthenticationFilter implements Filter {

    private String ignorePattern;

    private final ReentrantLock lock=new ReentrantLock();

    @Override
    public void destroy() {
        //无处理
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //拦截请求
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestMethod = request.getMethod();
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        if ("OPTIONS".equalsIgnoreCase(requestMethod)) {
            response.setStatus(HttpStatus.SC_OK);
            filterChain.doFilter(request, response);
            return;
        }
        SlwContext slwContext = new SlwContext(request, response);
        SlwContext.set(slwContext);
        //白名单逻辑
        if(isRequestUrlExcluded(request)){
            filterChain.doFilter(request, response);
            return;
        }
        StatusException se = null;
        //判断单点登录是否打开
        if(!SsoConfig.getInstance().isSsoOpen()){
            String cssSessionId = LoginUtil.getCssSessionIdByCookie(request);
            try {
                RestSUser user = LoginUtil.getSUserBySession(cssSessionId);
                if(user == null){
                    se = new StatusException(Response.Status.UNAUTHORIZED, "");
                    se.handleResult();
                    return;
                } else {
                    LoginUtil.setSUserToSession(user, cssSessionId);
                    filterChain.doFilter(request, response);
                    return;
                }
            } catch (Exception e) {
                se = new StatusException(Response.Status.UNAUTHORIZED, "");
                se.handleResult();
                return;
            }
        }
        //从主站获取用户信息
        SsoUser ssoUser = SsoClient.getSsoUser(request, response);
        if(ssoUser == null){
            String tourl =SsoConfig.getInstance().getSsoServer()+SsoConfig.getInstance().getSsoCheckAciton()+SsoConfig.getInstance().getSsoToUrl();
            se = new StatusException(Response.Status.UNAUTHORIZED, tourl);
            se.handleResult();
            return;
        }else{
            filterChain.doFilter(request, response);
            return ;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化属性
        this.ignorePattern = filterConfig.getInitParameter("ignorePattern");
    }
    private boolean isRequestUrlExcluded(final HttpServletRequest request) {
        //去掉后端的index.html
        if("/index.html".equals(request.getServletPath())){
            return true;
        }
        final StringBuffer urlBuffer = request.getRequestURL();
        if (request.getQueryString() != null) {
            urlBuffer.append("?").append(request.getQueryString());
        }
        final String requestUri = urlBuffer.toString();
        //正则表达式匹配
        return requestUri.matches(ignorePattern);
    }
}

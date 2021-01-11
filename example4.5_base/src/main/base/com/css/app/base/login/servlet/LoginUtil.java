package com.css.app.base.login.servlet;
import com.css.restclient.impl.model.RestSUser;
import org.slw.common.helper.PropsHelper;
import org.slw.framework.context.SlwContext;
import org.slw.rest.exception.StatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class LoginUtil {

    private static StatusException se = null;

    /**
     * 获取cookie中的cssSessionId值
     */
    public static String getCssSessionIdByCookie(HttpServletRequest request) {
        String cssSessionId = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("cssSessionId")){
                    cssSessionId = cookie.getValue();
                    break;
                }
            }
        }
        return cssSessionId;
    }

    /**
     * 设置cookie
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, RestSUser user) {
        String sessionId = request.getSession().getId();
        Cookie cookie = new Cookie("cssSessionId", sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
        setSUserToSession(user, sessionId);
    }

    /**
     * 设置-user
     */
    public static void setSUserToSession(RestSUser user, String sessionId) {
        Integer timeout = getTimeout();
        SlwContext.setSession(sessionId, user);//超时时间在web.xml中
    }

    /**
     * 获取-user
     */
    public static RestSUser getSUserBySession(String sessionId) {
        RestSUser user = (RestSUser) SlwContext.getSession(sessionId);
        return user;
    }

    /**
     * 删除-user
     */
    public static void delSUserBySession(String sessionId) {
        SlwContext.clearSession();
    }

    private static Integer timeout;

    public static Integer getTimeout() {
        if(timeout == null){
            Properties SSO_Props = PropsHelper.loadProps("slw-config.properties");
            timeout = PropsHelper.getInteger(SSO_Props, "login.timeout", 3600);
        }
        return timeout;
    }

    public static void main(String[] args) {

    }
}

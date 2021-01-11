package com.css.app.base.login.action;

import com.css.app.base.login.servlet.LoginUtil;
import com.css.restclient.exception.CssRestException;
import com.css.restclient.impl.model.RestSUser;
import com.css.restclient.inter.IUserClient;
import com.css.restclient.util.RestClientService;
import com.css.util.Messages;
import com.css.util.SM3Util;
import com.css.util.StringHelper;
import com.css.util.UuidUtil;

import org.slw.framework.context.SlwContext;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class Login {

    private RestSUser suser=null;

    public Login() {
    }

    public RestSUser getSuser() {
        return suser;
    }

    public void setSuser(RestSUser suser) {
        this.suser = suser;
    }

    public RestSUser execute(){

        String loginName=suser.getLoginName();
        String password = suser.getPassword();
        RestSUser user = null;
        if (StringHelper.isEmpty(loginName) || StringHelper.isEmpty(password)){
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));
        }
        try {
            user = RestClientService.getService(IUserClient.class)
                    .getUserByName(loginName);
        } catch (CssRestException e) {
            throw new StatusException(Response.Status.fromStatusCode(e.getStatus().getCode()), e.getMessage());
        }
        //账号不存在
        if (user == null){
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.accountNotExist"));
        }
        if (!user.getPassword().equals(SM3Util.SM3Encode((password)))) {
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.loginFaild"));
        }
        //设置cookie和缓存session
        LoginUtil.setCookie(SlwContext.request(), SlwContext.response(), user);
        return user;
    }


}

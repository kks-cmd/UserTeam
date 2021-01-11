package com.css.app.base.login.action;

import com.css.app.base.login.servlet.LoginUtil;
import com.css.restclient.impl.model.RestSUser;
import org.slw.framework.context.SlwContext;
import org.slw.sso.client.SsoClient;
import org.slw.sso.user.SsoUser;

public class GetUserByCssSsoTicket {
    private String cssSsoTicket = "";

    public String getCssSsoTicket() {
        return cssSsoTicket;
    }

    public void setCssSsoTicket(String cssSsoTicket) {
        this.cssSsoTicket = cssSsoTicket;
    }

    public GetUserByCssSsoTicket() {
    }

    public RestSUser execute(){
        SsoUser ssoUser = SsoClient.getSsoUser(SlwContext.request(), SlwContext.response());
        RestSUser user = new RestSUser();
        if(ssoUser != null){
            user.setUuid(ssoUser.getUserId());
            user.setRealName(ssoUser.getUserName());
            user.setLoginName(ssoUser.getLoginName());
            //保持会话sessionid从ssouser获取
            LoginUtil.setSUserToSession(user,ssoUser.getSessionId());
        }
        return user;
    }


}

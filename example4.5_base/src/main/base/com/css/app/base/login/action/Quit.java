package com.css.app.base.login.action;

import api.Mem;
import com.css.app.base.login.servlet.LoginUtil;
import org.slw.framework.context.SlwContext;
import org.slw.sso.config.SsoConfig;

public class Quit {

    public Quit() {
    }

    public String execute(){
        if(SsoConfig.getInstance().isSsoOpen()){
            String backUrl =SsoConfig.getInstance().getSsoToUrl();
            String toUrl = SsoConfig.getInstance().getQuitUrl() + "?toUrl=" + backUrl;
            return  toUrl;
        } else {
            String cssSessionId = LoginUtil.getCssSessionIdByCookie(SlwContext.request());
            LoginUtil.delSUserBySession(cssSessionId);

        }
        return  "";
    }
}

package com.css.app.base.login.action;

import com.css.app.base.login.servlet.LoginUtil;
import com.css.restclient.impl.model.RestSUser;
import org.slw.framework.context.SlwContext;

public class GetUserByCookie {
    public RestSUser execute(){
        String cssSessionId = LoginUtil.getCssSessionIdByCookie(SlwContext.request());
        RestSUser user = LoginUtil.getSUserBySession(cssSessionId);
        return user;
    }
}

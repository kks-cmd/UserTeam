package com.css.app.base.menu.action;

import com.css.restclient.exception.CssRestException;
import com.css.restclient.impl.model.RestSMenuItem;
import com.css.restclient.inter.IMenuClient;
import com.css.restclient.util.RestClientService;
import com.css.util.ListUtil;
import com.css.util.Messages;
import com.css.util.StringHelper;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;
import java.util.List;

public class ListMenu {

    String userId = null;
    String sysId = null ;

    public ListMenu() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public List<RestSMenuItem> execute(){

        String result = "";
        if(StringHelper.isAnyEmpty(userId,sysId))
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        List<RestSMenuItem> listMenus = null;
        try {
            listMenus = RestClientService.getService(IMenuClient.class)
                    .listMenus(userId,sysId);
        } catch (CssRestException e) {
            throw new StatusException(Response.Status.fromStatusCode(e.getStatus().getCode()), e.getMessage());
        }

        if(ListUtil.isLstEmpty(listMenus)){
            return null;
        }
        return listMenus;
    }


}

package com.css.app.base.menu.action;

import com.css.restclient.exception.CssRestException;
import com.css.restclient.impl.model.RestSMenu;
import com.css.restclient.inter.IMenuClient;
import com.css.restclient.util.RestClientService;
import com.css.util.Messages;
import com.css.util.StringHelper;
import org.slw.common.constant.RestStatus;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;
import java.util.List;

public class GetFastMenu {

    String userId = null;
    String sysId = null ;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetFastMenu() {
    }

    public List<RestSMenu> execute(){
        if(StringHelper.isEmpty(userId))
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        List<RestSMenu> fastMenuList = null;
        try {
            fastMenuList = RestClientService.getService(IMenuClient.class)
                    .getFastMenuList(sysId);
        } catch (CssRestException e) {
            throw new StatusException(Response.Status.fromStatusCode(e.getStatus().getCode()), e.getMessage());
        }
        return fastMenuList;
    }


}

package com.css.app.base.auth.action;

import com.css.restclient.exception.CssRestException;
import com.css.restclient.impl.model.RestSFunc;
import com.css.restclient.impl.model.RestSFuncAction;
import com.css.restclient.inter.IUserClient;
import com.css.restclient.util.RestClientService;
import com.css.util.StringHelper;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoadAuth {

    private String userId=null;

    private String sysId=null;


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

    public LoadAuth() {
    }

    public Set<String> execute(){
        if(StringHelper.isAnyEmpty(userId,sysId))
            return null;
        Set<String> functions = new HashSet<String>();
        if(StringHelper.isNotEmpty(userId)) {
            List<RestSFunc> functionList = null;
            List<RestSFuncAction> actionsList = null;

            try {
                functionList = RestClientService.getService(IUserClient.class)
                        .getFuncByUserIdAndSysId(userId,sysId);
            } catch (CssRestException e) {
                throw new StatusException(Response.Status.fromStatusCode(e.getStatus().getCode()), e.getMessage());
            }
            if (functionList != null && functionList.size() > 0) {
                for (RestSFunc func : functionList) {
                    functions.add(func.getFuncId());
                }
            }

            try {
                actionsList = RestClientService.getService(IUserClient.class)
                        .getFuncActionByUserIdAndSysId(userId,sysId);
            } catch (CssRestException e) {
                throw new StatusException(Response.Status.fromStatusCode(e.getStatus().getCode()), e.getMessage());
            }
            if (actionsList != null && actionsList.size() > 0) {
                for (RestSFuncAction action : actionsList) {
                    functions.add(action.getActionCode());
                }
            }

        }
        return  functions;
    }

}

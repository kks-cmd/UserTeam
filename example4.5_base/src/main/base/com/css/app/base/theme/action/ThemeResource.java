package com.css.app.base.theme.action;

import api.DictMan;
import com.css.apps.base.dict.model.SDict;
import com.css.core.configuration.Environment;
import com.css.core.exception.CssException;
import com.css.db.query.QueryDict;
import com.css.db.query.TransactionCache;
import com.css.util.Ajax;
import com.css.util.Messages;
import com.css.util.StringHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/theme")
@Tag(description = "主题", name = "")
@Server(url = "/rest/theme")
@SlwRestService
public class ThemeResource {

    @GET
    @Path("/loadTheme")
    @ActionInvoke(actionName = LoadTheme.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String loadTheme() {
        return null;
    }

    @POST
    @Path("/changeTheme")
    @Operation(summary = "切换主题")
    @Produces(MediaType.APPLICATION_JSON)
    public static String changeTheme(@QueryParam(value = "desc")@Parameter(description = "主题路径", required = true)String desc){
        String result = "";
        if(StringHelper.isEmpty(desc)) {
            throw new CssException(Messages.getString("systemMsg.fieldEmpty"));
        }
        SDict dict = DictMan.getDictType("d_para_g","17");
        dict.setName(desc);
        TransactionCache tc= null;
        try {
            tc= new QueryDict().getTransaction();
            tc.update(dict);
            tc.commit();
            result = Ajax.JSONResult(Environment.RESULT_CODE_SUCCESS, Messages.getString("slw.success"));
        } catch (Exception e) {
            result = Ajax.JSONResult(Environment.RESULT_CODE_ERROR, Messages.getString("slw.failed"));
        }
       return result;
    }
}

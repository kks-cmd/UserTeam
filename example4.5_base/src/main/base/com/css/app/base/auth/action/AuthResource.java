package com.css.app.base.auth.action;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
@Tag(description = "权限", name = "")
@Server(url = "/rest/auth")
@SlwRestService
public class AuthResource {

    @GET
    @Path("/loadAuth")
    @ActionInvoke(actionName = LoadAuth.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String loadAuth(@QueryParam(value = "userId") String userId, @QueryParam(value = "sysId") String sysId) {
        return null;
    }
}

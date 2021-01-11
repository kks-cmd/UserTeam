package com.css.app.base.vcode.action;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vcode")
@Tag(description = "验证码", name = "")
@Server(url = "/rest/vcode")
@SlwRestService
public class VCodeResource {

    @GET
    @Path("/refreshVCode")
    @ActionInvoke(actionName = RefreshVCode.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String refreshVCode() {
        return null;
    }
}

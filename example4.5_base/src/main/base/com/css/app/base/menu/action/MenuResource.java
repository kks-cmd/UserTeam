package com.css.app.base.menu.action;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/menu")
@Tag(description = "菜单", name = "")
@Server(url = "/rest/menu")
@SlwRestService
public class MenuResource {

    @GET
    @Path("/getFastMenu")
    @ActionInvoke(actionName = GetFastMenu.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String loadMenu(@QueryParam(value = "userId")String userId,
                                  @QueryParam(value = "sysId")String sysId) {
    return null;
    }

    /**
     * 根据用户ID及系统ID获取菜单列表
     * @param userId
     * @return List<SMenu>
     */
    @GET
    @Path("/listMenus")
    @ActionInvoke(actionName = ListMenu.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String listMenus(@QueryParam(value = "userId")String userId,
                                   @QueryParam(value = "sysId")String sysId){
        return null;
    }
}

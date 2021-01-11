package com.css.app.base.login.action;

import com.css.restclient.impl.model.RestSUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/suser")
@Tag(description = "登录", name = "user")
@Server(url = "/rest/suser")
@SlwRestService
public class LoginResource {

    /**
     * 检测服务是否可正常访问
     */
    @GET
    @Path("")
    @Operation(summary = "检测服务是否可正常访问")
    public static void checkRest(){
    }

    /**
     * 验证用户名和密码
     * @param suser 用户对象
     * @return IServiceResult<SUser>
     */
    @POST
    @Path("/login")
    @ActionInvoke(actionName = Login.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static String login(RestSUser suser){
        return null;
    }



    /**
     * 退出方法
     */
    @GET
    @Path("/quit")
    @ActionInvoke(actionName = Quit.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String quit() {
        return null;
    }

    /**
     * 通过ssSsoTicketc获取用户
     */
    @GET
    @Path("/getUserByCssSsoTicket")
    @ActionInvoke(actionName = GetUserByCssSsoTicket.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String getUserByCssSsoTicket(@QueryParam(value = "cssSsoTicket")String cssSsoTicket) {
        return null;
    }
    /**
     * 通过Cookie获取用户
     */
    @GET
    @Path("/getUserByCookie")
    @ActionInvoke(actionName = GetUserByCookie.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String getUserByCssSsoTicket() {
        return null;
    }

}

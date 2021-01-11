package com.css.app.base.sdict.action;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/sdict")
@Tag(description = "字典", name = "")
@Server(url = "/rest/sdict")
@SlwRestService
public class SDictResource {
    private static Map<String, String> fieldMap = new HashMap<>();
    static {
        fieldMap.put("uuid", "uuid");
        fieldMap.put("parentId", "parentId");
        fieldMap.put("tableName", "tableName");
        fieldMap.put("replyNum", "replyNum");
        fieldMap.put("tableType", "tableType");
        fieldMap.put("orderNum", "orderNum");
    }

    @GET
    @Path("/loadDict")
    @ActionInvoke(actionName = LoadDict.class)
    @Produces(MediaType.APPLICATION_JSON)
    public static String loadDict(@QueryParam(value = "dictArray")String dictArray) {
        return  null;
    }

}

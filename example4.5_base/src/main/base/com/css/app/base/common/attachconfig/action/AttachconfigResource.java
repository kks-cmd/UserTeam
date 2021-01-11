
package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.model.PageQuery;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/attachconfig")
@Tag(description = "上传配置接口", name = "attachconfig")
@Server(url = "/restserver/rest")
@SlwRestService
public class AttachconfigResource {

	/**
	 * 添加上传配置
	 *
	 * @param item 上传配置
	 * @return Attachconfig
	 */
	@POST
	@Path("/addAttachconfig")
	@ActionInvoke(actionName = AddAttachconfig.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addAttachconfig(Attachconfig item){
		return null;
	}

	/**
	 * 删除上传配置
	 *
	 * @param ids 上传配置ids
	 * @return ids
	 */
	@POST
	@Path("/delAttachconfig")
	@ActionInvoke(actionName = DelAttachconfig.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String delAttachconfig(List<String> ids){
		return null;
	}

	/**
	 * 修改上传配置
	 *
	 * @param item 上传配置
	 * @return  Attachconfig
	 */
	@POST
	@Path("/updAttachconfig")
	@ActionInvoke(actionName = UpdAttachconfig.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String updAttachconfig(Attachconfig item){
		return null;
	}

	/**
	 * 获取上传配置
	 *
	 * @param uuid 上传配置uuid
	 * @return Attachconfig
	 */
	@GET
	@Path("/getAttachconfig")
	@ActionInvoke(actionName = GetAttachconfig.class)
	@Produces(MediaType.APPLICATION_JSON)
		public static String getAttachconfig(@QueryParam(value ="uuid") String uuid){
		return null;
	}

	/**
	 * 查询上传配置
	 *
	 * @param pageQuery
	 * @return Page
	 */
	@POST
	@Path("/dirAttachconfig")
	@ActionInvoke(actionName = DirAttachconfig.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String DirAttachconfig(PageQuery pageQuery){
		return null;
	}
	

}
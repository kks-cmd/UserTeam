package com.css.app.base.common.attach.action;
import com.css.app.base.common.file.model.FileMain;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.fileupload.FileItem;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/fileattach")
@Tag(description = "拖拽上传接口", name = "fileattach")
@Server(url = "/restserver/rest")
@SlwRestService
public class FileAttachResource {
	/**
	 * 添加上传配置
	 *
	 * @param item 上传配置
	 * @return Attachconfig
	 */
	@POST
	@Path("/checkfileMd5")
	@ActionInvoke(actionName = CheckFileMd5.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String checkFileMd5(FileMain item){
		return null;
	}

	/**
	 * 上传附件
	 * @param parentId 父id
	 * @param fileMd5 md5加密值
	 * @param name 附件名称
	 * @param fileType 表记录ID
	 * @param file 附件
	 * @return
	 */
	@POST
	@Path("/uploadAttach")
	@ActionInvoke(actionName = UploadAttach.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static void uploadAttach(
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "parentId") String parentId,
			@QueryParam(value = "fileMd5") String fileMd5,
			@QueryParam(value = "name") String name,
			@QueryParam(value = "fileType") String fileType,
			@QueryParam(value = "file") FileItem file) {
	}

	/**
	 * 获取上传配置
	 *
	 * @param uuid 上传配置uuid
	 * @return Attachconfig
	 */
	@GET
	@Path("/getfileattach")
	@ActionInvoke(actionName = GetFileAttach.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static String getFileAttach(@QueryParam(value ="uuid") String uuid){
		return null;
	}
}

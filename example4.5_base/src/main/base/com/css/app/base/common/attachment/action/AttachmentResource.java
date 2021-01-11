
package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.CropAttachData;
import com.css.app.base.common.attachment.model.SortAttachData;
import com.css.app.base.common.model.PageQuery;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.fileupload.FileItem;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/attachment")
@Tag(description = "附件管理接口", name = "attachment")
@Server(url = "/restserver/rest")
@SlwRestService
public class AttachmentResource {

	/**
	 * 查询附件列表
	 * @param pageQuery
	 * @return	Page
	 */
	@POST
	@Path("/dirAttachment")
	@ActionInvoke(actionName = DirAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String dirAttachment(PageQuery pageQuery) {
		return null;
	}

	/**
	 * 上传附件
	 * @param userId 用户ID
	 * @param tableName 业务表名
	 * @param tableKey 业务关键字
	 * @param tableUuid 表记录ID
	 * @param x
	 * @param y
	 * @param rotate 旋转角度
	 * @param width
	 * @param height
	 * @param name 附件名称
	 * @param fileType 附件类型
	 * @param file 附件
	 * @return
	 */
	@POST
	@Path("/uploadAttachment")
	@ActionInvoke(actionName = UploadAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static String uploadAttachment(
			@QueryParam(value = "userId") String userId,
			@QueryParam(value = "tableName") String tableName,
			@QueryParam(value = "tableKey") String tableKey,
			@QueryParam(value = "tableUuid") String tableUuid,
			@QueryParam(value = "domain") Integer domain,
			@QueryParam(value = "x") Integer x,
			@QueryParam(value = "y") Integer y,
			@QueryParam(value = "rotate") Integer rotate,
			@QueryParam(value = "width") Integer width,
			@QueryParam(value = "height") Integer height,
			@QueryParam(value = "name") String name,
			@QueryParam(value = "fileType") String fileType,
			@QueryParam(value = "file") FileItem file) {
		return null;
	}

	/**
	 * 下载附件
	 * @param uuid 附件ID
	 * @param mod 模式
	 * @return
	 */
	@GET
	@Path("/downloadAttachment")
	@ActionInvoke(actionName = DownloadAttachment.class)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public static void downloadAttachment(@QueryParam(value = "uuid")String uuid,@QueryParam(value = "mod")Integer mod) {}

	/**
	 * 附件排序
	 * @param sortAttach 排序数据
	 * @return
	 */
	@POST
	@Path("/sortAttachment")
	@ActionInvoke(actionName = SortAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static String sortAttachment(SortAttachData sortAttach) {
		return null;
	}

	/**
	 * 原有图片剪裁
	 * @param cropAttach 剪裁图片数据
	 * @return
	 */
	@POST
	@Path("/cropAttachment")
	@ActionInvoke(actionName = CropAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static String cropAttachment(CropAttachData cropAttach) {
		return null;
	}

	/**
	 * 加载附件
	 * @param item 附件对象
	 * @return
	 */
	@POST
	@Path("/loadAttachment")
	@ActionInvoke(actionName = LoadAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String loadAttachment(Attachment item) {
		return null;
	}

	/**
	 * 获取附件
	 * @param item 附件对象
	 * @return
	 */
	@GET
	@Path("/getAttachment")
	@ActionInvoke(actionName = GetAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String getAttachment(Attachment item) {
		return null;
	}

	/**
	 * 获取裁剪附件
	 * @param item 附件对象
	 * @return
	 */
	@POST
	@Path("/getCropAttachment")
	@ActionInvoke(actionName = GetCropAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String getCropAttachment(Attachment item) {
		return null;
	}

	/**
	 * 修改附件
	 * @param item 附件对象
	 * @return
	 */
	@POST
	@Path("/updAttachment")
	@ActionInvoke(actionName = UpdAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String updAttachment(Attachment item) {
		return null;
	}

	/**
	 * 删除附件
	 * @param ids 附件Ids
	 * @return
	 */
	@POST
	@Path("/delAttachment")
	@ActionInvoke(actionName = DelAttachment.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String delAttachment(List<String> ids) {
		return null;
	}



}
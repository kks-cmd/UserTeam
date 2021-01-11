package com.css.app.base.common.attachment.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.slw.common.utils.SlwJson;
import org.slw.rest.exception.StatusException;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.CropInfo;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.app.base.common.attachment.service.ExtService;
import com.css.app.base.common.upload.AttachItem;
import com.css.app.base.common.upload.FileInfo;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.ImageService;
import com.css.util.Messages;
import com.css.util.StringHelper;
import com.css.util.UuidUtil;

public class UploadAttachment {
	private String userId;
	private String tableName;
	private String tableKey;
	private String tableUuid;
	private String domain;
	private Integer x, y, rotate, width, height;
	private String name;
	private String fileType;
	private FileItem file;
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String execute() {
		String fileAttach = "7";
		if (!checkField()){
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));
		}

		Attachment item = new Attachment();
		item.setTableName(tableName);
		item.setTableKey(tableKey);
		item.setTableUuid(tableUuid);
		item.initMd5Uuid();
		Attachconfig config = item.getAttachconfig();
		if (config == null){
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.attachconfig"));
		}

		CropInfo crop = AttachService.getCropInfo(config);
		name = file.getName();
		String sExt = AttachService.getFileExt(name);
		name = AttachService.getFileName(name);
		String ext = config.getFileExt();
		if (!ext.equals("*")) {
			if (sExt.equals("") || ext.indexOf(sExt) < 0){
				throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.invalidFileExt"));
			}
		}
		Integer maxLength = config.getFileLength();
		if (file.getSize() > 1024l * maxLength){
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.totalMaxSize"));
		}

		Attachment old = null;
		boolean updateFlag = false;
		if (crop != null) {
			old = QueryCache.get(Attachment.class, item.getMd5Uuid());
			if (old != null)
				updateFlag = true;
		} else {
			if (config.getFileNumber() > 0) {
				if (item.getSize() >= config.getFileNumber()){
					throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.attachMaxNumber"));
				}
			}
		}

		FileInfo fi = AttachItem.getAttach(fileAttach);
		if (fi == null){
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.invalidFilePath"));
		}
		fi.setDescription(file.getName());
		fi.setFileName(UUID.randomUUID() + "." + sExt);
		String fileName = fi.getFilePath() + "/" + fi.getFileName();

		File saveFile = new File(fileName);
		String category = ExtService.getCategory(sExt);
		try {
			file.write(saveFile);
			if (crop != null) {
				String newFile = fileName + "." + "0." + sExt;
				// ie6,7,8,9必须先上传文件
				if (x == null || y == null || width == null || height == null) {
					Integer pos[] = ImageService.getPosition(saveFile, crop.getWidth(), crop.getHeight(), 0.6f);
					if (pos == null)
						throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.invalidFileExt"));
					x = pos[0];
					y = pos[1];
					width = pos[2];
					height = pos[3];
				}
				ImageService.corpImage(fileName, newFile, x, y, width, height);
				ImageService.cropImageCenter(newFile, fileName + "." + sExt, crop.getWidth(), crop.getHeight());
				int i = 0;
				List<Integer> widths = crop.getCropWidth();
				if (widths != null) {
					for (Integer w : widths) {
						i++;
						ImageService.zoomImage(fileName + "." + "0." + sExt, fileName + "." + i + "." + sExt, w, Math.round(w * height / width));
					}
					SlwJson extreData = new SlwJson();
					extreData.put("x", x);
					extreData.put("y", y);
					extreData.put("width", width);
					extreData.put("height", height);
					extreData.put("rotate", rotate);
					extreData.put("number", widths.size());
					item.setExtraData(extreData.toString());
				}
			} else if ("pic".equals(category) && width != null && height != null) {
				ImageService.cropImageCenter(fileName, fileName + "." + sExt, width, height);
			}
		} catch (Exception e) {
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("slw.failed"));
		}

		item.setUuid(config.getFileNumber() == 1 ? item.getMd5Uuid() : UuidUtil.getUuid());
		item.setFileName(name);
		item.setFileSize(file.getSize());
		item.setFileExt(sExt);
		item.setOrderNum(item.getSize() + 1);


		item.setCategory(category);
		item.setFileType(fileType);
		item.setFileUrl(fi.getRelativePath() + "/" + fi.getFileName());
		item.setUploadTime(new Date());
		item.setUserId(userId);
		item.setServerId(fi.getServerId());
		item.setFileUrlFull(fi.getDictUrl() + item.getFileUrl());

		TransactionCache tx = new QueryCache().getTransaction();
		if (updateFlag)
			tx.update(item);
		else
			tx.save(item);
		tx.commit();
		if (!updateFlag)
			item.getJionList().add(item.getUuid());
		else
			AttachService.delFiles(old);

		JSONObject one = new JSONObject();
		one.put("uuid", item.getUuid());
		one.put("userId", item.getUserId());
		one.put("fileUrlFull", item.getFileUrlFull());
		one.put("fileName", item.getFileName());
		one.put("fileExt", item.getFileExt());
		one.put("fileSize", item.getFileSize());
		one.put("time", new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.getUploadTime()));
		if(StringHelper.isEmpty(domain)){
			return ""+one;
		}else{
			return "<script>document.domain ='"+domain+"';</script>"+one;
		}
	}

	public boolean checkField() {
		if (file != null)
			if (StringHelper.isNotEmpty(tableName))
				if (StringHelper.isNotEmpty(tableKey))
					if (StringHelper.isNotEmpty(tableUuid))
						return true;
		return false;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableKey() {
		return tableKey;
	}
	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}
	public String getTableUuid() {
		return tableUuid;
	}
	public void setTableUuid(String tableUuid) {
		this.tableUuid = tableUuid;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getRotate() {
		return rotate;
	}
	public void setRotate(Integer rotate) {
		this.rotate = rotate;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public FileItem getFile() {
		return file;
	}
	public void setFile(FileItem file) {
		this.file = file;
	}
}

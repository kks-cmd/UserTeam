package com.css.app.base.common.attachment.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slw.common.utils.SlwJson;
import org.slw.framework.context.SlwContext;
import org.slw.rest.exception.StatusException;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.CropAttachData;
import com.css.app.base.common.attachment.model.CropInfo;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.app.base.common.upload.AttachItem;
import com.css.app.base.common.upload.FileInfo;
import com.css.apps.base.user.model.SUser;
import com.css.core.configuration.Environment;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.ImageService;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class CropAttachment {
	private CropAttachData cropAttach ;

	public CropAttachData getCropAttach() {
		return cropAttach;
	}

	public void setCropAttach(CropAttachData cropAttach) {
		this.cropAttach = cropAttach;
	}

	public JSONObject execute() {
		String fileAttach = "7";
		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));
		
		cropAttach.getItem().initMd5Uuid();
		Attachment old = QueryCache.get(Attachment.class, cropAttach.getItem().getMd5Uuid());
		if (old == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.readError"));

		Attachconfig config = cropAttach.getItem().getAttachconfig();
		if (config == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.attachconfig"));

		CropInfo crop = AttachService.getCropInfo(config);
		if (crop == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.attachconfig"));

		String sExt = old.getFileExt();
		String oldFileName = AttachService.getFilePath(old);

		FileInfo fi = AttachItem.getAttach(fileAttach);
		if (fi == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.invalidFilePath"));

		fi.setFileName(UUID.randomUUID() + "." + sExt);
		String fileName = fi.getFilePath() + "/" + fi.getFileName();
		try {
			FileUtils.copyFile(new File(oldFileName), new File(fileName));
			
			AttachService.delFiles(old);
			String newFile = fileName + "." + "0." + sExt;
			ImageService.corpImage(fileName, newFile, cropAttach.getX(), cropAttach.getY(), cropAttach.getWidth(), cropAttach.getHeight());
			ImageService.cropImageCenter(newFile, fileName + "." + sExt, crop.getWidth(), crop.getHeight());
			int i = 0;
			List<Integer> widths = crop.getCropWidth();
			if (widths != null) {
				for (Integer w : widths) {
					i++;
					ImageService.zoomImage(fileName + "." + "0." + sExt, fileName + "." + i + "." + sExt, w, Math.round(w * cropAttach.getHeight() / cropAttach.getWidth()));
				}
				SlwJson extreData = new SlwJson();
				extreData.put("x", cropAttach.getX());
				extreData.put("y", cropAttach.getY());
				extreData.put("width", cropAttach.getWidth());
				extreData.put("height", cropAttach.getHeight());
				extreData.put("rotate", cropAttach.getRotate());
				extreData.put("number", widths.size());
				old.setExtraData(extreData.toString());
				old.setUploadTime(new Date());
				SUser user = (SUser) SlwContext.getSession(Environment.SESSION_LOGIN_KEY);
				old.setUserId(user.getUserId());
				old.setFileUrl(fi.getRelativePath() + "/" + fi.getFileName());
				old.setFileUrlFull(fi.getDictUrl() + old.getFileUrl());
			}
			TransactionCache tx = new QueryCache().getTransaction();
			tx.update(old);
			tx.commit();
		} catch (Exception e) {
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("slw.failed")); 
		}
		JSONObject one = new JSONObject();
		one.put("uuid", old.getUuid());
		one.put("userId", old.getUserId());
		one.put("fileUrlFull", old.getFileUrlFull());
		one.put("fileExt", old.getFileExt());
		one.put("time", new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(old.getUploadTime()));
		return one;
	}

	public boolean checkField() {
		if (cropAttach.getItem() != null)
			if (cropAttach.getX() != null && cropAttach.getY() != null && cropAttach.getWidth() != null && cropAttach.getHeight() != null)
				if (StringHelper.isNotEmpty(cropAttach.getItem().getTableName()))
					if (StringHelper.isNotEmpty(cropAttach.getItem().getTableKey()))
						if (StringHelper.isNotEmpty(cropAttach.getItem().getTableUuid()))
							return true;
		return false;
	}

}

package com.css.app.base.common.attach.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.slw.rest.exception.StatusException;

import com.css.app.base.common.attach.model.FileAttach;
import com.css.app.base.common.file.model.FileMain;
import com.css.app.base.common.file.service.ExtService;
import com.css.app.base.common.upload.AttachItem;
import com.css.app.base.common.upload.FileInfo;
import com.css.apps.base.dict.model.SDict;
import com.css.core.configuration.Environment;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import com.css.util.UuidUtil;

import api.DictMan;

public class UploadAttach {
	private String userId = null;
	private String parentId = null;
	private String fileMd5 = null;
	private String name = null;
	private String fileType = null;
	private FileItem file;
//	@IgnoredField
//	public static String fileAttach = "7";

	public void execute() {
		String fileAttach = "7";
		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.fieldEmpty"));

		FileMain to = QueryCache.get(FileMain.class, parentId);
		if (to == null)
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.readError"));

		/*if (!userId.equals(to.getUserId()))
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.authError"));
*/
		List addList = new ArrayList();
		FileAttach exist = QueryCache.get(FileAttach.class, fileMd5);
		if (exist == null) {
			String sExt = StringHelper.getFileExt(file.getName());
			SDict tmpDict = DictMan.getDictType("d_file", "8");
			if (tmpDict != null) {
				String ext = tmpDict.getName();
				if (!ext.equals("*")) {
					if (sExt.equals("") || ext.indexOf(sExt) < 0)
						throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.invalidFileExt"));
				}
			}
			tmpDict = null;
			tmpDict = DictMan.getDictType("d_file", "9");
			if (tmpDict != null) {
				if (file.getSize() > 1000l * 1000 * Integer.parseInt(DictMan.getDictType("d_file", "9").getName()))
					throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.totalMaxSize"));
			}
			FileInfo fi = AttachItem.getAttach(fileAttach);
			if (fi == null)
				throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.invalidFilePath"));

			fi.setDescription(file.getName());
			fi.setFileName(UUID.randomUUID() + "." + sExt);
			String fileName = fi.getFilePath() + "/" + fi.getFileName();

			File saveFile = new File(fileName);
			try {
				file.write(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}


			String category = ExtService.getCategory(sExt);
			if ("pic".equals(category)) {
				int size = 125;
				tmpDict = DictMan.getDictType("d_file", "1");
				if (tmpDict != null)
					size = Integer.parseInt(tmpDict.getName());
				//ImageService.cropImage(fileName, fileName + "." + sExt, size, true);
			}
			exist = new FileAttach();
			exist.setFileMd5(fileMd5);
			exist.setName(name);
			exist.setFileSize(file.getSize());
			exist.setFileExt(sExt);
			exist.setCategory(category);
			exist.setFileType(fileType);
			exist.setFileUrl(fi.getRelativePath() + "/" + fi.getFileName());
			exist.setCreateTime(new Date());
			exist.setComplete(1);
			exist.setUserId(userId);
			exist.setServerId(fi.getServerId());
			addList.add(exist);
		}
		FileMain tmp = new FileMain();
		try {
			BeanUtils.copyProperties(tmp, exist);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		tmp.setUuid(UuidUtil.getUuid());
		tmp.setCreateTime(new Date());
		tmp.setUserId(userId);
		tmp.setParentId(parentId);
		tmp.setName(name);
		tmp.setIsFolder(Environment.FALSE);
		tmp.setFavourite(Environment.FALSE);
		tmp.setPublicFlag(Environment.FALSE);
		addList.add(tmp);
		TransactionCache tx = new QueryCache().getTransaction();
		tx.save(addList);
		tx.commit();
	}

	public boolean checkField() {
		if (file != null)
			if (StringHelper.isNotEmpty(name))
				if (StringHelper.isNotEmpty(parentId))
					if (StringHelper.isNotEmpty(fileMd5))
						return true;
		return false;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFileMd5() {
		return fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
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

/*	public  static void main(String args[]){
		Field[] f = UploadAttach.class.getDeclaredFields();
		System.out.println("2");

	}*/

}

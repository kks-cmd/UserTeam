
package com.css.app.base.common.file.service;

import java.io.File;
import java.io.IOException;

import api.DictMan;
import com.css.app.base.common.attach.model.FileAttach;
import com.css.app.base.common.file.model.FileMain;
import org.apache.commons.io.FileUtils;

import com.css.db.query.QueryCache;

/**
 * 
 * 
 * @author CSS. WeidongWang
 * @since 2016-6-9
 * @version 0.1
 */
public class FileService {
	public static String FAVOURITE = "favourite";
	public static String SHARE = "share";

	public static byte[] getFileByte(FileMain item) {
		String fileName = getFilePath(item);
		if (fileName == null)
			return null;
		try {
			return FileUtils.readFileToByteArray(new File(fileName));
		} catch (IOException e) {
			return null;
		}
	}

	public static File getFile(FileMain item) {
		String fileName = getFilePath(item);
		if (fileName == null)
			return null;
		File file = new File(fileName);
		return file.exists() ? file : null;

	}

	public static String getFilePath(FileMain item) {
		if (item == null)
			return null;
		FileAttach fa = QueryCache.get(FileAttach.class, item.getFileMd5());
		if (fa == null)
			return null;
		String path = DictMan.getDictType("d_serverid", fa.getServerId()).getRemark();
		return path + fa.getFileUrl();
	}

	public static String getFileUrl(FileMain item) {
		if (item == null)
			return null;
		FileAttach fa = QueryCache.get(FileAttach.class, item.getFileMd5());
		if (fa == null)
			return null;
		String path = DictMan.getDictType("d_serverid", fa.getServerId()).getName();
		return path + fa.getFileUrl();
	}

}

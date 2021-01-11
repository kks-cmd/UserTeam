package com.css.app.base.common.attachment.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import org.slw.common.utils.SlwJson;
import org.slw.mvc.annotation.IgnoredField;

import com.css.apps.base.dict.model.SDict;
import com.css.util.StringHelper;

import api.DictMan;

@SuppressWarnings("serial")
public class AttachmentJson implements Serializable {
	@IgnoredField
	private static Map<String, String> fieldMap = new HashMap<>();
	static {
		fieldMap.put("tableName", "tableName");
		fieldMap.put("tableKey", "tableKey");
		fieldMap.put("md5Uuid", "md5Uuid");
		fieldMap.put("tableType", "tableType");
		fieldMap.put("uploadTime", "uploadTime");
		fieldMap.put("fileUrl", "fileUrl");
		fieldMap.put("fileType", "fileType");
		fieldMap.put("serverId", "serverId");
		fieldMap.put("extraData", "extraData");
	}

	private Attachconfig config;
	private List<Attachment> list;

	public String toJson() {
		return SlwJson.toJSON(this, fieldMap);
	}

	public Attachconfig getConfig() {
		return config;
	}

	public void setConfig(Attachconfig config) {
		this.config = config;
	}

	public List<Attachment> getList() {
		return list;
	}

	public void setList(List<Attachment> list) {
		if (list == null)
			return;
		this.list = list;
		Map<String, String> serveridMap = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Attachment item : this.list) {
			String path = (String) serveridMap.get(item.getServerId());
			if (StringHelper.isEmpty(path)) {
				SDict dict = DictMan.getDictType("d_serverid", item.getServerId());
				if (dict == null)
					System.out.println(item.getUuid() + "," + item.getServerId());
				path = dict.getName();
				serveridMap.put(item.getServerId(), path);
			}
			item.setFileUrlFull(path + item.getFileUrl());
			item.setTime(sdf.format(item.getUploadTime()));
		}

	}
}
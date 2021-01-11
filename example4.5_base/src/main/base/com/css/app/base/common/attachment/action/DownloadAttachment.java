package com.css.app.base.common.attachment.action;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.core.Response;
import org.slw.common.utils.StreamUtil;
import org.slw.framework.view.model.StreamData;
import org.slw.rest.exception.StatusException;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.db.query.QueryCache;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class DownloadAttachment{
	private String uuid;
	private Integer mod;  

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getMod() {
		return mod;
	}

	public void setMod(Integer mod) {
		this.mod = mod;
	}

	public void execute(){
		if (StringHelper.isEmpty(uuid))
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));
		Attachment item = QueryCache.get(Attachment.class, uuid);
		if (item == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.readError"));

		File file = AttachService.getFile(item);
		if (file == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.downError"));
		if (mod == null)
			mod = StreamData.MOD_DOWNLOAD;
		
		String fileName = item.getFileName() + (StringHelper.isEmpty(item.getFileExt()) ? "" : "." + item.getFileExt());
		try {
			StreamUtil.downloadAttach(file, fileName);
		} catch (IOException e) {
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.downError"));
		}
	}
}

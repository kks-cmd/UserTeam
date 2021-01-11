package com.css.app.base.common.attachment.action;

import javax.ws.rs.core.Response;
import org.slw.rest.exception.StatusException;
import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.CropInfo;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.db.query.QueryCache;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class GetCropAttachment {
	private Attachment item;

	public Attachment getItem() {
		return item;
	}

	public void setItem(Attachment item) {
		this.item = item;
	}

	public Attachment execute() {
		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.fieldEmpty"));

		item.initMd5Uuid();
		Attachconfig config = item.getAttachconfig();
		if (config == null)
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.readError"));

		CropInfo crop = AttachService.getCropInfo(config);
		if (crop == null)
			throw new StatusException(Response.Status.BAD_REQUEST,Messages.getString("systemMsg.readError"));

		item = QueryCache.get(Attachment.class, item.getMd5Uuid());
		return item;
	}

	public boolean checkField() {
		if (item != null)
			if (StringHelper.isNotEmpty(item.getTableName()))
				if (StringHelper.isNotEmpty(item.getTableKey()))
					if (StringHelper.isNotEmpty(item.getTableUuid()))
						return true;
		return false;
	}
}

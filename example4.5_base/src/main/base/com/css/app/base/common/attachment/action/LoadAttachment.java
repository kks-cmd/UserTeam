package com.css.app.base.common.attachment.action;

import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.slw.rest.exception.StatusException;
import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.AttachmentJson;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class LoadAttachment {
	private Attachment item;

	public Attachment getItem() {
		return item;
	}

	public void setItem(Attachment item) {
		this.item = item;
	}

	public AttachmentJson execute() {
		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));
		Attachconfig config = item.getAttachconfig();
		if (config == null)
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.readError"));

		AttachmentJson msg = new AttachmentJson();

		msg.setConfig(config);
		if ("no".equals(item.getLoadData()))
			msg.setList(new ArrayList<Attachment>());
		else
			msg.setList(AttachService.getAttachments(item));

		return msg;
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

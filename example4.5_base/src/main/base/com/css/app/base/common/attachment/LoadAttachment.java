package com.css.app.base.common.attachment;

import java.util.ArrayList;

import org.slw.common.utils.Ajax;
import org.slw.framework.annotation.RequestMapping;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.AttachmentJson;
import com.css.app.base.common.attachment.service.AttachService;
import com.css.core.configuration.Environment;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class LoadAttachment {

	@RequestMapping(caption = "加载附件")
	public String execute(Attachment item) {
		String result = "";
		if (!checkField(item)){
			result = Ajax.jsonResult(Environment.RESULT_CODE_ERROR, Messages.getString("systemMsg.fieldEmpty"), null);
            return result;
		}
		Attachconfig config = item.getAttachconfig();
		if (config == null){
			result = Ajax.jsonResult(Environment.RESULT_CODE_ERROR, Messages.getString("systemMsg.readError"), null);
            return result;
		}

		AttachmentJson msg = new AttachmentJson();

		msg.setConfig(config);
		if ("no".equals(item.getLoadData()))
			msg.setList(new ArrayList<Attachment>());
		else
			msg.setList(AttachService.getAttachments(item));

		result = Ajax.jsonResult(Environment.RESULT_CODE_SUCCESS, Messages.getString("slw.success"), msg.toJson());
		return result;
	}

	public boolean checkField(Attachment item) {
		if (item != null)
			if (StringHelper.isNotEmpty(item.getTableName()))
				if (StringHelper.isNotEmpty(item.getTableKey()))
					if (StringHelper.isNotEmpty(item.getTableUuid()))
						return true;
		return false;
	}

}

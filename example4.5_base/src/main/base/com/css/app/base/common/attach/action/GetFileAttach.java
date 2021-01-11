package com.css.app.base.common.attach.action;

import com.css.app.base.common.attach.model.FileAttach;
import com.css.core.action.CssAction;
import com.css.core.exception.CssException;
import com.css.db.query.QueryCache;
import com.css.util.Messages;
import com.css.util.StringHelper;

import org.slw.mvc.annotation.SetIgnoredField;

public class GetFileAttach extends CssAction {
	private String uuid = null;
	@SetIgnoredField
	private FileAttach item = null;

	public void execute() {
		if (StringHelper.isEmpty(uuid)) {
			item = new FileAttach();
		} else {
			item = QueryCache.get(FileAttach.class, uuid);
			if (item == null)
				throw new CssException(Messages.getString("systemMsg.readError"));
		}
	}
}

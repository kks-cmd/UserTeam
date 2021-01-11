package com.css.app.base.common.attach.action;

import java.util.Date;

import com.css.app.base.common.attach.model.FileAttach;
import com.css.app.base.common.file.model.FileMain;
import com.css.core.action.CssAction;
import com.css.core.configuration.Environment;
import com.css.core.exception.CssException;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import com.css.util.UuidUtil;

import org.slw.framework.context.SlwContext;
import org.slw.framework.view.model.ActionResult;
import org.slw.mvc.annotation.ModelField;

public class CheckFileMd5 extends CssAction {
	@ModelField
	private FileMain item = null;

	public void execute() {
		if (!checkField())
			throw new CssException(Messages.getString("systemMsg.fieldEmpty"));
		FileMain to = QueryCache.get(FileMain.class, item.getParentId());
		if (to == null)
			throw new CssException(Messages.getString("systemMsg.readError"));
		if (!sUser.getUserId().equals(to.getUserId()))
			throw new CssException(Messages.getString("systemMsg.authError"));

		FileAttach exist = QueryCache.get(FileAttach.class, item.getFileMd5());
		if (exist == null) {
			SlwContext.result().set(ActionResult.OTHER, Messages.getString("systemMsg.dataEmpty"), null);
			return;
		}
		item.setUuid(UuidUtil.getUuid());
		item.setCreateTime(new Date());
		item.setFileType(exist.getFileType());
		item.setFileSize(exist.getFileSize());
		item.setFileExt(exist.getFileExt());
		item.setCategory(exist.getCategory());
		item.setUserId(sUser.getUserId());
		item.setPublicFlag(Environment.FALSE);
		item.setFavourite(Environment.FALSE);
		item.setIsFolder(Environment.FALSE);
		TransactionCache tx = new QueryCache().getTransaction();
		tx.save(item);
		tx.commit();
	}

	public boolean checkField() {
		if (item != null)
			if (StringHelper.isNotEmpty(item.getParentId()))
				if (StringHelper.isNotEmpty(item.getFileMd5()))
					if (StringHelper.isNotEmpty(item.getName()))
						return true;
		return false;
	}

}

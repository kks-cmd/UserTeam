package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class UpdAttachment {

	private Attachment item = null;

	public Attachment getItem() {
		return item;
	}

	public void setItem(Attachment item) {
		this.item = item;
	}


	public Attachment execute() {
		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

		Attachment old = QueryCache.get(Attachment.class, item.getUuid());
		if (old == null)
			throw new StatusException(Messages.getString("systemMsg.readError"));


		if (!equals(old, item)) {
			old.setFileName(item.getFileName());
			TransactionCache tx = new QueryCache().getTransaction();
			tx.update(old);
			tx.commit();
		}
		return item;
	}

	public boolean checkField() {
		if (item != null)
			if (StringHelper.isNotEmpty(item.getFileName()))
				return true;
		return false;
	}

	public boolean equals(Attachment oldObj, Attachment newObj) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(oldObj.getFileName());
		sb2.append(newObj.getFileName());
		return sb1.toString().equals(sb2.toString());
	}
}

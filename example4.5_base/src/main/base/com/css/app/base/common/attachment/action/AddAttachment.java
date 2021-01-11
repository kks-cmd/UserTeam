package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import com.css.util.UuidUtil;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;

public class AddAttachment {
	
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

				item.setUuid(UuidUtil.getUuid());
			TransactionCache tx = new QueryCache().getTransaction();
			tx.save(item);
			tx.commit();
		
		return item;
	}
	
	public boolean checkField(){
		if (item != null)
			if (StringHelper.isNotEmpty(item.getFileName()))
			return true;
		return false; 
	}
}

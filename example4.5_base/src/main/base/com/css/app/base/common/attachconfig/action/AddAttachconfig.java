package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.UuidUtil;
import com.css.util.StringHelper;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class AddAttachconfig {
	
	private Attachconfig item = null;
	
	public Attachconfig getItem() {
        return item;
    }

    public void setItem(Attachconfig item) {
        this.item = item;
    }

	public Attachconfig execute() {
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
			if (StringHelper.isNotEmpty(item.getName()))
			if (StringHelper.isNotEmpty(item.getTableName()))
			if (StringHelper.isNotEmpty(item.getTableKey()))
			if (item.getFileLength()!=null)
			if (item.getFileNumber()!=null)
			if (StringHelper.isNotEmpty(item.getFileExt()))
			return true;
		return false; 
	}
}

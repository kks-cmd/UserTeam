package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class UpdAttachconfig {

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

			Attachconfig old = QueryCache.get(Attachconfig.class, item.getUuid());
			if (old == null) 
				throw new StatusException(Messages.getString("systemMsg.readError"));

			if(!equals(old,item)){
			 	old.setName(item.getName());
			 	old.setTableName(item.getTableName());
			 	old.setTableKey(item.getTableKey());
			 	old.setFileLength(item.getFileLength());
			 	old.setFileNumber(item.getFileNumber());
			 	old.setFileExt(item.getFileExt());
			 	old.setOrdernum(item.getOrdernum());
			 	old.setExtraPara(item.getExtraPara());
		    	TransactionCache tx = new QueryCache().getTransaction();
				tx.update(old);
				tx.commit();
			}
			 return item;
	}
	
	public boolean checkField(){
		if (item != null)
 		if (StringHelper.isNotEmpty(item.getUuid()))
 		if (StringHelper.isNotEmpty(item.getName()))
 		if (StringHelper.isNotEmpty(item.getTableName()))
 		if (StringHelper.isNotEmpty(item.getTableKey()))
		if (item.getFileLength()!=null)
		if (item.getFileNumber()!=null)
 		if (StringHelper.isNotEmpty(item.getFileExt()))
    	return true;
    return false; 
	}
	
	public boolean equals(Attachconfig oldObj,Attachconfig newObj){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
     	sb1.append(oldObj.getName());
     	sb2.append(newObj.getName());
     	sb1.append(oldObj.getTableName());
     	sb2.append(newObj.getTableName());
     	sb1.append(oldObj.getTableKey());
     	sb2.append(newObj.getTableKey());
     	sb1.append(oldObj.getFileLength());
     	sb2.append(newObj.getFileLength());
     	sb1.append(oldObj.getFileNumber());
     	sb2.append(newObj.getFileNumber());
     	sb1.append(oldObj.getFileExt());
     	sb2.append(newObj.getFileExt());
     	sb1.append(oldObj.getOrdernum());
     	sb2.append(newObj.getOrdernum());
     	sb1.append(oldObj.getExtraPara());
     	sb2.append(newObj.getExtraPara());
    	return sb1.toString().equals(sb2.toString());
	}
}

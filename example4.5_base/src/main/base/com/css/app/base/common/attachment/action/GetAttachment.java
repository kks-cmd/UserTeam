
package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.db.query.QueryCache;
import com.css.util.StringHelper;
import org.slw.common.utils.Messages;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class GetAttachment{
	private String uuid  = null;

	public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
	

	public Attachment execute() {
		Attachment item = null;
			if (StringHelper.isEmpty(uuid)){
				item = new Attachment();
			} else {
				item = QueryCache.get(Attachment.class, uuid);
				if (item == null) 
					throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

			}
		 return item;
	}
}

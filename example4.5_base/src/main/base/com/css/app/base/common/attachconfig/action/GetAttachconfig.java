
package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.db.query.QueryCache;
import com.css.util.StringHelper;
import org.slw.common.utils.Messages;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;

public class GetAttachconfig{
	private String uuid  = null;

	public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
	

	public Attachconfig execute() {
		Attachconfig item = null;
			if (StringHelper.isEmpty(uuid)){
				item = new Attachconfig();
			} else {
				item = QueryCache.get(Attachconfig.class, uuid);
				if (item == null) 
					throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

			}
		 return item;
	}
}

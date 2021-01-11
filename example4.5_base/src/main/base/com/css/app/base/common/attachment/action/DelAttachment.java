package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.ListUtil;
import com.css.util.Messages;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;
import java.util.List;

public class DelAttachment {
	
	private List<String> ids;
	
	public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

	public List<String> execute() {
		 if (ListUtil.isLstEmpty(ids))
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

		List<Attachment> lstObj = QueryCache.idToObj(Attachment.class, ids);
		if (lstObj != null && lstObj.size() > 0) {
				TransactionCache tx = new QueryCache().getTransaction();
				tx.delete(lstObj);
				tx.commit();
		}
		return ids;
	}
}

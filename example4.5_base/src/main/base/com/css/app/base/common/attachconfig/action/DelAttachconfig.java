package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.ListUtil;
import com.css.util.Messages;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;
import java.util.List;

public class DelAttachconfig {
	
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

		List<Attachconfig> lstObj = QueryCache.idToObj(Attachconfig.class, ids);
		if (lstObj != null && lstObj.size() > 0) {
				TransactionCache tx = new QueryCache().getTransaction();
				tx.delete(lstObj);
				tx.commit();
		}
		return ids;
	}
}

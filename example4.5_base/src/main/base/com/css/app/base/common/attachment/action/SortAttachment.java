package com.css.app.base.common.attachment.action;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.slw.rest.exception.StatusException;
import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.attachment.model.SortAttachData;
import com.css.db.query.QueryCache;
import com.css.db.query.TransactionCache;
import com.css.util.Messages;
import com.css.util.StringHelper;

public class SortAttachment {
	private SortAttachData sortAttach;

	public SortAttachData getSortAttach() {
		return sortAttach;
	}

	public void setSortAttach(SortAttachData sortAttach) {
		this.sortAttach = sortAttach;
	}

	public void execute() {
		if (StringHelper.isEmpty(sortAttach.getSortStr()))
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

		if (!checkField())
			throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

		sortAttach.getItem().initMd5Uuid();

		List<Attachment> updList = new ArrayList<Attachment>();
		String[] itemsStr = sortAttach.getSortStr().split(",");
		int orderNum = itemsStr.length;
		for (String items : itemsStr) {
			if (StringHelper.isNotEmpty(items)) {
				Attachment tmp = QueryCache.get(Attachment.class, items);
				if (tmp != null && tmp.getMd5Uuid().equals(sortAttach.getItem().getMd5Uuid())) {
					if (tmp.getOrderNum() == null || tmp.getOrderNum() != orderNum) {
						tmp.setOrderNum(orderNum);
						updList.add(tmp);
					}
					orderNum--;
				}
			}
		}
		if (updList != null && updList.size() > 0) {
			TransactionCache tx = new QueryCache().getTransaction();
			tx.update(updList);
			tx.commit();
			sortAttach.getItem().getJionList().removeAll();
		}
	}

	public boolean checkField() {
		if (sortAttach.getItem() != null)
			if (StringHelper.isNotEmpty(sortAttach.getItem().getTableName()))
				if (StringHelper.isNotEmpty(sortAttach.getItem().getTableKey()))
					if (StringHelper.isNotEmpty(sortAttach.getItem().getTableUuid()))
						return true;
		return false;
	}

}

package com.css.app.base.common.attachment.action;

import com.css.app.base.common.attachment.model.Attachment;
import com.css.app.base.common.model.PageQuery;
import com.css.db.page.Page;
import com.css.db.query.QueryCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import net.sf.json.JSONObject;
import org.slw.rest.exception.StatusException;
import javax.ws.rs.core.Response;
import java.util.Map;

public class DirAttachment {
	PageQuery pageQuery = null;

    public DirAttachment() {}

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    };

	public Page execute() {
		Page page = pageQuery.getPage();
		if(pageQuery == null)
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        Map<String,Object> map = pageQuery.getItem();
        if(map == null || page == null)
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        page.setCountField("a.uuid");
        Attachment item = (Attachment)JSONObject.toBean(JSONObject.fromObject(map),Attachment.class);
        QueryCache qc = new QueryCache("select a.uuid from Attachment a " + getWhere(item) + getOrder(page));
		setWhere(qc, item);
        page = qc.page(page);
        page.setResults(QueryCache.idToObj(Attachment.class, page.getResults()));
        return page;
	}

	public String getWhere(Attachment item) {
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (StringHelper.isNotEmpty(item.getTableName()))
			sb.append("and a.tableName like :tableName ");
		if (StringHelper.isNotEmpty(item.getTableKey()))
			sb.append("and a.tableKey like :tableKey ");
		if (StringHelper.isNotEmpty(item.getTableUuid()))
			sb.append("and a.tableUuid like :tableUuid ");
		if (StringHelper.isNotEmpty(item.getFileName()))
			sb.append("and a.fileName like :fileName ");
		if (StringHelper.isNotEmpty(item.getUserId()))
			sb.append("and a.userId like :userId ");
		return sb.toString();
	}

	public void setWhere(QueryCache qc, Attachment item) {
		if (StringHelper.isNotEmpty(item.getTableName()))
			qc.setParameter("tableName", "%" + item.getTableName().trim() + "%");
		if (StringHelper.isNotEmpty(item.getTableKey()))
			qc.setParameter("tableKey", "%" + item.getTableKey().trim() + "%");
		if (StringHelper.isNotEmpty(item.getTableUuid()))
			qc.setParameter("tableUuid", "%" + item.getTableUuid().trim() + "%");
		if (StringHelper.isNotEmpty(item.getFileName()))
			qc.setParameter("fileName", "%" + item.getFileName().trim() + "%");
		if (StringHelper.isNotEmpty(item.getUserId()))
			qc.setParameter("userId", "%" + item.getUserId().trim() + "%");
	}

	public String getOrder(Page page) {
		return StringHelper.isNotEmpty(page.getOrderByString()) ? page.getOrderByString() : " order by a.uuid";
	}
}

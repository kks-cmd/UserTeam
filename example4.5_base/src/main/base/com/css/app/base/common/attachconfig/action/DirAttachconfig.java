package com.css.app.base.common.attachconfig.action;

import com.css.app.base.common.attachconfig.model.Attachconfig;
import com.css.app.base.common.model.PageQuery;
import com.css.app.base.common.util.CreateGson;
import com.css.db.page.Page;
import com.css.db.query.QueryCache;
import com.css.util.Messages;
import com.css.util.StringHelper;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.slw.rest.exception.StatusException;

import javax.ws.rs.core.Response;
import java.util.Map;

public class DirAttachconfig {
	
	PageQuery pageQuery = null;

    public DirAttachconfig() {

    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }
	
	public Page execute() {
		if(pageQuery == null)
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        Page page = pageQuery.getPage();
        Map<String,Object> map = pageQuery.getItem();
        if(map == null || page == null)
            throw new StatusException(Response.Status.BAD_REQUEST, Messages.getString("systemMsg.fieldEmpty"));

        page.setCountField("a.uuid");
		Gson gson = CreateGson.createGson();
		Attachconfig item = gson.fromJson(JSONObject.fromObject(map).toString(), Attachconfig.class);

			QueryCache qc = new QueryCache("select a.uuid from Attachconfig a " + getWhere(item) + getOrder(page));
			setWhere(qc,item);
			page = qc.page(page);
			page.setResults(QueryCache.idToObj(Attachconfig.class, page.getResults()));
			return page;
	}
	public String getWhere(Attachconfig item) {
		StringBuffer sb = new StringBuffer(" where 1=1");
	
		 		if (StringHelper.isNotEmpty(item.getTableName()))
					sb.append(" and a.tableName like :tableName");
		 		if (StringHelper.isNotEmpty(item.getTableKey()))
					sb.append(" and a.tableKey like :tableKey");
    return sb.toString(); 
	}
	public void setWhere(QueryCache qc, Attachconfig item) {
			  	if (StringHelper.isNotEmpty(item.getTableName()))
			  		qc.setParameter("tableName", "%" + item.getTableName().trim() + "%");
			  	if (StringHelper.isNotEmpty(item.getTableKey()))
			  		qc.setParameter("tableKey", "%" + item.getTableKey().trim() + "%");
	}
	public String getOrder(Page page) {
		return StringHelper.isNotEmpty(page.getOrderByString()) ? page.getOrderByString() : " order by a.uuid";
	}
}

package com.css.app.base.common.model;

import com.css.db.page.Page;

import java.util.Map;

public class PageQuery {

    private Map<String,Object> item = null;

    private Page page = null;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Map<String, Object> getItem() {
        return item;
    }

    public void setItem(Map<String, Object> item) {
        this.item = item;
    }
}

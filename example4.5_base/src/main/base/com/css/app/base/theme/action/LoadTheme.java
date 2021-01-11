package com.css.app.base.theme.action;

import api.DictMan;

public class LoadTheme {

    public LoadTheme() {
    }

    public String execute(){

        String desc = DictMan.getDictName("d_para_g","17");
        return desc;
    }





}

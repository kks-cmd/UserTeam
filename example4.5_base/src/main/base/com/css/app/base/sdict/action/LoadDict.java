package com.css.app.base.sdict.action;

import api.DictMan;
import com.css.apps.base.dict.model.SDict;
import com.css.util.StringHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadDict {

    public LoadDict() {
    }

    String dictArray = null;

    public String getDictArray() {
        return dictArray;
    }

    public void setDictArray(String dictArray) {
        this.dictArray = dictArray;
    }

    public Map<String, List<SDict>> execute(){
        if (StringHelper.isEmpty(dictArray))
            return null;
        return getDictJson(dictArray);
    }
    public static Map<String, List<SDict>> getDictJson(String dictArray) {
        String[] code = dictArray.split(",");
        Map<String, List<SDict>> map = new HashMap<>();
        for (int i = 0; i < code.length; i++) {
            String[] key = code[i].split("@");
            String table, dictId;
            if (key.length < 2) {
                table = "d_root";
                dictId = code[i].trim();
            } else {
                table = key[0].trim();
                dictId = key[1].trim();
            }
            List<SDict> lst= DictMan.getDictTypeList(table, dictId);
            map.put(code[i], lst);
        }
        return map;
    }

}

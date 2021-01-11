package com.css.app.base.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CreateGson {
	/**
	 * 让gson序列化null值
	 * @return
	 */
	public static Gson createGson(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		return gsonBuilder.create();
	}
}

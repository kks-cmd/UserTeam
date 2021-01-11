package com.css.app.base.common.attachment.service;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.css.util.StringHelper;

public class ExtService {
	public static String doc[] = { "txt", "doc", "docx", "ppt", "pptx", "pptm", "xls", "xlsx", "wps", "rtf", "htm",
			"html", "pdf" };
	public static String pic[] = { "ai", "bmp", "cur", "dcx", "emf", "eps", "gif", "icn", "ico", "iff", "jpg", "jpeg",
			"jpe", "jif", "pcd", "pcx", "pic", "pix", "png", "exif", "svg", "raw", "ras", "rsb", "sgi", "tga", "tiff",
			"wmf" };
	public static String music[] = { "ac3", "ape", "aac", "amr", "cda", "flac", "mp1", "mp2", "mp3", "wav", "wma",
			"m4a", "mid", "mka", "mpa", "mpc", "mmf", "ofr", "ogg", "ra", "ram", "wv", "tta", "dts" };
	public static String video[] = { "wmv", "asf", "asx", "divx", "rm", "rmvb", "mpg", "mpeg", "mpe", "3gp", "mov",
			"mp4", "m4v", "avi", "dat", "mkv", "flv", "vob" };
	private static HashMap<String, String> typeMap;
	static {
		typeMap = new LinkedHashMap<String, String>();
		addType("doc", doc);
		addType("pic", pic);
		addType("music", music);
		addType("video", video);
	}
	private static void addType(String typeName, String[] ext) {
		for (int i = 0; i < ext.length; i++)
			typeMap.put(ext[i], typeName);
	}
	public static String getCategory(String ext) {
		String category = typeMap.get(ext);
		return StringHelper.isEmpty(category) ? "other" : category;
	}
}

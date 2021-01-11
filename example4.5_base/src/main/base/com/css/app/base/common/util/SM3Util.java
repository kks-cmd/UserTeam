package com.css.app.base.common.util;


import com.css.util.SM3Digest;
import org.bouncycastle.util.encoders.Hex;


public class SM3Util {
	
	public static final String SM3Encode(String str) {
		byte[] md = new byte[32];
		byte[] msg1 = str.getBytes();
		SM3Digest sm3 = new SM3Digest();
		sm3.update(msg1, 0, msg1.length);
		sm3.doFinal(md, 0);
		String s = new String(Hex.encode(md));
		return s;
	}
	
	public static void main(String[] args){
	}
}

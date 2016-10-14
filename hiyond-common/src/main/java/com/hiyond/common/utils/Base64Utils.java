package com.hiyond.common.utils;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.hiyond.common.utils.DigestUtils.DigestEnum;


/**
 * 
 * @author hiyond
 *
 */
public class Base64Utils {

	/**
	 * 字符串转byte[]
	 * @param e 参数字符串
	 * @return 返回byte数组
	 */
	public static byte[] ToByteArray(String e){
		if(StringUtils.isBlank(e)){
			return null;
		}
		return e.getBytes();
	}
	
	public static String ToString(byte[] e){
		if(e == null){
			return null;
		}
		return new String(e);
	}
	
	/**
	 * 加密
	 * @param e
	 * @return
	 */
	public static byte[] encode(String e){
		byte[] str = ToByteArray(e);
		if(str != null){
			return Base64.encodeBase64(str);
		}
		return null;
	}
	
	/**
	 * 解密
	 * @param e
	 * @return
	 */
	public static String decode(String e){
		if(e != null){
			return new String(Base64.decodeBase64(e));
		}
		return null;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String a = new String(encode("哈哈哈"));
		System.out.println(a);
		System.out.println(decode(a));
		System.out.println(DigestUtils.digest("呵呵呵", DigestEnum.MD5));
	}
	
}

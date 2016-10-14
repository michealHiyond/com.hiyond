package com.hiyond.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 * 
 * @author hiyond
 *
 */
public class DigestUtils {

	/**
	 * 生成加密字符串
	 * @param e 原始字符串
	 * @param digestEnum 加密方式[MD5,SHA-1]
	 * @return 加密的字符串
	 * @throws NoSuchAlgorithmException
	 */
	public static String digest(String e, DigestEnum digestEnum) throws NoSuchAlgorithmException {
		String encryptType = digestEnum.getDigestType();
		MessageDigest messageDigest = MessageDigest.getInstance(encryptType);
		byte[] inputArray = e.getBytes();
		byte[] hashArray = messageDigest.digest(inputArray);
		StringBuilder builder = new StringBuilder();
		for(byte bt : hashArray){
			int value = bt & 0xff;
			if(value < 16){
				builder.append("0");
			}
			builder.append(Integer.toHexString(value));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(digest("呵呵呵", DigestEnum.MD5));
		System.out.println(org.apache.commons.codec.digest.DigestUtils.md5Hex("呵呵呵"));
		System.out.println(org.apache.commons.codec.digest.DigestUtils.sha1Hex("呵呵呵"));
		System.out.println(digest("呵呵呵", DigestEnum.SHA_1));
	}

	public enum DigestEnum {
		MD5("MD5"), 
		SHA_1("SHA-1");
		
		private String digestType;

		DigestEnum(String digestType) {
			this.digestType = digestType;
		}

		public String getDigestType(){
			return this.digestType;
		}

	}

}

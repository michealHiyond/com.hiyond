package com.hiyond.common.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 加密工具
 * 
 * @author hiyond
 *
 */
public class MessageDigestUtils {

	public static String digest(String e, MessageDigestEnum messageDigestEnum) throws NoSuchAlgorithmException {
		String  encryptType = messageDigestEnum.getDigestType();
		MessageDigest messageDigest = MessageDigest.getInstance(encryptType);
		byte[] inputArray = e.getBytes();
		byte[] hashArray = messageDigest.digest(inputArray);
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < hashArray.length; i++) {
			int value = hashArray[i] & 0xff;
			if(value < 16){
				buffer.append("0");
			}
			buffer.append(Integer.toHexString(value));
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(digest(null,MessageDigestEnum.MD5));
		System.out.println(new String(DigestUtils.md5Hex("呵呵呵")));
		System.out.println(DigestUtils.sha1Hex("呵呵呵"));
		System.out.println(digest("呵呵呵",MessageDigestEnum.SHA_1));
	}

	public enum MessageDigestEnum {
		MD5("MD5"), 
		SHA_1("SHA-1");
		
		private String digestType;

		MessageDigestEnum(String digestType) {
			this.digestType = digestType;
		}
		
		public void setDigestType(String digestType) {
			this.digestType = digestType;
		}
		
		public String getDigestType(){
			return this.digestType;
		}

	}

}

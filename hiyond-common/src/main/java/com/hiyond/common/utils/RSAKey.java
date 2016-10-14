package com.hiyond.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 非对称加密
 * Created by hiyond on 2016/9/5.
 */
public class RSAKey {

    /**
     * 生成RSA keyPair
     * @return KeyPair
     */
    public static KeyPair keyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            return keyPairGenerator.generateKeyPair();
        }catch (NoSuchAlgorithmException e){
            return null;
        }
    }

    /**
     * 根据KeyPair 生成PublicKey
     * @param keyPair KeyPair
     * @return PublicKey的字符串
     */
    public static String publicKey(KeyPair keyPair) {
        PublicKey pubKey = keyPair.getPublic();
        return Base64.encodeBase64String(pubKey.getEncoded());
    }

    /**
     * 根据KeyPair 生成PrivateKey
     * @param keyPair
     * @return PrivateKey的字符串
     */
    public static String privateKey(KeyPair keyPair) {
        PrivateKey priKey = keyPair.getPrivate();
        return Base64.encodeBase64String(priKey.getEncoded());
    }

    /**
     * 字符串转PublicKey
     * @param text PublicKey的字符串
     * @return PublicKey 出错返回null
     */
    public static PublicKey string2PublicKey(String text) {
        try {
            byte[] keys = Base64.decodeBase64(text);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keys);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 字符串转PrivateKey
     * @param text PrivateKey的字符串
     * @return PrivateKey 出错返回null
     */
    public static PrivateKey string2PrivateKey(String text) {
        try {
            byte[] keys = Base64.decodeBase64(text);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keys);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        KeyPair keyPair = RSAKey.keyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        String publicKeyStr = publicKey(keyPair);
        String privateKeyStr = privateKey(keyPair);
        System.out.println("123465");
        System.out.println(publicKeyStr);
        System.out.println(privateKeyStr);
        PublicKey publicKey1 = string2PublicKey(publicKeyStr);
        PrivateKey privateKey1 = string2PrivateKey(privateKeyStr);

        System.out.println(publicKey1.equals(publicKey)+"----"+privateKey1.equals(privateKey));

        KeyPair pair = RSAKey.keyPair();
        System.out.println(publicKey(pair));
        System.out.println(privateKey(pair));
    }
}

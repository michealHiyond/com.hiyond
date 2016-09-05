package com.hiyond.common.tools;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Map;

/**
 * 非对称加密
 * Created by hiyond on 2016/9/5.
 */
public class RSAKey {

    private String publicKey;

    private String privateKey;

    public RSAKey() {
        try{
            KeyPair keyPair = keyPair();
            if(keyPair != null){
                PublicKey pubKey = keyPair.getPublic();
                this.publicKey = Base64.encodeBase64String(pubKey.getEncoded());
                PrivateKey priKey = keyPair.getPrivate();
                this.privateKey = Base64.encodeBase64String(priKey.getEncoded());
            }
        }catch (Exception e){
            System.out.println("生成秘钥失败");
        }
    }

    /**
     * 生成RSA keyPair
     * @return KeyPair
     */
    private KeyPair keyPair() {
        try {

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            return keyPairGenerator.generateKeyPair();
        }catch (NoSuchAlgorithmException e){
            return null;
        }
    }

    private String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public static void main(String[] args) {
        RSAKey rsaKey = new RSAKey();
        System.out.println("Private:"+rsaKey.getPrivateKey());
        System.out.println("Public:"+rsaKey.getPublicKey());

    }
}

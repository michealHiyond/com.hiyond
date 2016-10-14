package com.hiyond.constant;

import com.hiyond.common.properties.PropertiesUtil;
import com.hiyond.common.utils.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 * Created by hiyond on 2016/9/28.
 */
public class Passwd {

    public static String createPasswd(String s) throws NoSuchAlgorithmException {
        String passwd = getPasswdProperties();
        s = s + passwd;
        s = DigestUtils.digest(s, DigestUtils.DigestEnum.SHA_1);
        return s;
    }

    public static String getPasswdProperties() {
        Properties properties = PropertiesUtil.getProperties("/passwd.properties");
        try {
            return properties.get("passwd").toString();
        }catch (Exception e){
        }
        return null;
    }
}

package com.hiyond.common.utils;

import java.util.UUID;

/**
 * 
 * @author Hiyond
 *
 */
public class UuidUtils {

    /**
     * 产生一个UUID字符串 
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
    
}

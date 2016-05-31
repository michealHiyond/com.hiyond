package com.hiyond.common.tools;

import java.util.UUID;

/**
 * 
 * @author Hiyond
 *
 */
public class UUIDTools {

    /**
     * 产生一个UUID字符串 
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    
}

package com.hiyond.common.io;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hiyond on 2016/9/9.
 */
public class IOTest {

    public static void file(String path) {
        File file = new File(path);
        if(file.exists()){
            if (file.isDirectory()){
                for (String s : file.list()){
                    System.out.println(s);
                }
            }
        }
    }

    public static void main(String[] args) {
//        String path = "D://hiyond//books";
//        file(path);

//        System.out.println(NumberUtils.isNumber("001"));
//        System.out.println(Double.valueOf(".01"));
//        System.out.println((Double.valueOf("0.01") - Double.valueOf(".01")) == 0);
//        System.out.println(Double.valueOf("300").equals(Double.valueOf("0300")));
        String[] array = {"a","b"};
        System.out.println(Arrays.asList(array));
    }
}

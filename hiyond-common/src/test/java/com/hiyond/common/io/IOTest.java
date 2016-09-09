package com.hiyond.common.io;

import java.io.File;

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
        String path = "D://hiyond//books";
        file(path);
    }
}

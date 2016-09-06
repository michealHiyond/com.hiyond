package com.hiyond.common.thread;

import com.hiyond.common.threadNotify.ThreadA;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by hiyond on 2016/9/6.
 */
public class ThreadTest implements Runnable {

    private Integer threadId;

    public ThreadTest(Integer threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
//        System.out.println(threadId);
        for (int i = 0;i<10;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(args.length);
        for (String s : args){
            System.out.println(s);
        }
        for (int i = 0;i<1;i++){
            ThreadTest threadTest = new ThreadTest(i);
            Thread thread = new Thread(threadTest);
            thread.start();
        }
    }
}

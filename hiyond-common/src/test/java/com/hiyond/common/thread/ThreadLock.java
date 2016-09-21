package com.hiyond.common.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hiyond on 2016/9/20.
 */
public class ThreadLock implements Runnable{
    private Integer threadIndex;

    public ThreadLock(Integer threadIndex){
        this.threadIndex = threadIndex;
    }

    private Lock lock = new ReentrantLock();

    public void print() {
        lock.lock();
        int i = 0;
        while(i<5){
            System.out.println("线程："+threadIndex+"--"+i);
            i++;
        }
        lock.unlock();
    }


    @Override
    public void run() {
        print();
    }

    public static void main(String[] args) {
        for(int i = 1;i<5;i++){
            Thread thread = new Thread(new ThreadLock(i));
            thread.start();
        }
    }
}

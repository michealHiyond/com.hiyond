package com.hiyond.activeMq.config;

/**
 * Created by hiyond on 2016/10/11.
 */

import org.apache.activemq.ActiveMQConnection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ActiveMqConfig {

    private static Lock lock = new ReentrantLock();

    public static final String USER_NAME;

    public static final String PASSWORD;

    public static final String BROKE_URL;

    public static final int SEND_NUM;

    static {
        USER_NAME = ActiveMQConnection.DEFAULT_USER;

        PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

        BROKE_URL  = ActiveMQConnection.DEFAULT_BROKER_URL;

        SEND_NUM = 10;
    }

    private ActiveMqConfig() {
    }

    private static void init() {
        lock.lock();
        try {

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}

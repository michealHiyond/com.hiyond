package com.hiyond.zookeeper;

import com.hiyond.common.constant.ZKConstant;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hiyond on 2016/10/21.
 */
public class zookeeper implements Watcher{

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper(ZKConstant.ZK_SERVER,5000,new ZooKeeperConstructorUsageSimple());

    }


    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}

package com.hiyond.zookeeper;

import org.apache.zookeeper.AsyncCallback;

public class ZookeeperCallBack {

    class ZookeeperStringCallBack implements AsyncCallback.StringCallback {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("StringCallback result:["+"rc:"+rc+",path:"+path+",ctx:"+ctx+",name:"+name+"]");
        }
    }

    class ZookeeperVoidCallBack implements AsyncCallback.VoidCallback {

        @Override
        public void processResult(int rc, String path, Object ctx) {
            System.out.println("VoidCallback result:["+"rc:"+rc+",path:"+path+",ctx:"+ctx+"]");
        }
    }
}

package com.hiyond.zookeeper;

import com.hiyond.common.constant.ZKConstant;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZookeeperSimple implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private ZooKeeper zooKeeper = null;

    private static Stat stat = new Stat();

    private String path = "/hiyondSyn";

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watchedEvent:"+watchedEvent);
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if(Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()){
                countDownLatch.countDown();
            } else if(watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                try {
                    List<String> list = zooKeeper.getChildren(watchedEvent.getPath(),true);
                    System.out.println(watchedEvent.getPath()+"节点数据变化："+list);
                    for (String data : list) {
                        System.out.println(watchedEvent.getPath()+"/"+data+
                                            " value:"+new String(zooKeeper.getData(path+"/"+data,true,stat))+
                                            " vrsion:"+stat.getVersion());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ZookeeperSimple zookeeperSimple = new ZookeeperSimple();
        zookeeperSimple.initZookeeperWithSidAndPasswdSimple();
    }

    /**
     * 创建一个基本的Zookeeper实例
     * @throws IOException exception
     */
    private void initZookeeperBaseSimple() throws Exception {
        this.zooKeeper = new ZooKeeper(ZKConstant.ZK_SERVER,5000,this);
        System.out.println("zooKeeper state:"+zooKeeper.getState());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个复用Session与passwd的Zookeeper实例
     * @throws IOException exception
     */
    private void initZookeeperWithSidAndPasswdSimple() throws Exception {
        this.zooKeeper = new ZooKeeper(ZKConstant.ZK_SERVER,5000,this);
        System.out.println("zooKeeper state:"+zooKeeper.getState());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long sessionId = zooKeeper.getSessionId();
        byte[] passwd = zooKeeper.getSessionPasswd();
        zooKeeper = new ZooKeeper(ZKConstant.ZK_SERVER,5000,this,sessionId,passwd);
        String data = null;
        data = "hiyondSynData";
        String resultPath = ZookeeperUtils.createNodeIsSynchronized(zooKeeper,path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(resultPath);
        System.out.println(zooKeeper.getChildren(path,true));

        resultPath = ZookeeperUtils.createNodeIsSynchronized(zooKeeper,path+"/c1",data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(resultPath);



//        path = "/hiyond";
//        data = "/hiyondData";
//        ZookeeperUtils.createNode(zooKeeper,path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT,new ZookeeperCallBack().new ZookeeperStringCallBack(),"this is a context message!");
//        ZookeeperUtils.deleteNodeIsSynchronized(zooKeeper,path,0);
//        ZookeeperUtils.deleteNode(zooKeeper,path,0,new ZookeeperCallBack().new ZookeeperVoidCallBack(),"this is a context message for delete Node!");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

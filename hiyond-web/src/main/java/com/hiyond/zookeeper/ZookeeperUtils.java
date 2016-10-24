package com.hiyond.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

import java.util.List;

public class ZookeeperUtils {

    /**
     * 创建同步节点
     * @param zooKeeper zk对象
     * @param path 节点路径
     * @param data 数据
     * @param aclList 节点ACL策略
     * @param createMode 创建的节点类型
     * @return string
     * @throws Exception 异常
     */
    public static String createNodeIsSynchronized(ZooKeeper zooKeeper, final String path, byte[] data, List<ACL> aclList, CreateMode createMode) throws Exception {
        return zooKeeper.create(path, data,aclList,createMode);
    }

    /**
     * 创建同步节点
     * @param zooKeeper zk对象
     * @param path 节点路径
     * @param data 数据
     * @param aclList 节点ACL策略
     * @param createMode 创建的节点类型
     * @param callback 异步回调函数
     * @param object 传递一个对象在回调函数时使用
     * @throws Exception 异常
     */
    public static void createNode(ZooKeeper zooKeeper, final String path, byte[] data, List<ACL> aclList, CreateMode createMode, AsyncCallback.StringCallback callback, Object object) throws Exception {
        zooKeeper.create(path,data,aclList,createMode,callback,object);
    }

    /**
     * 同步删除节点
     * @param zooKeeper zooKeeper对象
     * @param path  节点路径
     * @param version   版本号
     * @throws Exception Exception
     */
    public static void deleteNodeIsSynchronized(ZooKeeper zooKeeper, final String path, int version) throws Exception {
        zooKeeper.delete(path,version);
    }

    /**
     * 异步删除节点
     * @param zooKeeper zooKeeper对象
     * @param path  节点路径
     * @param version   版本号
     * @param callback   回调函数
     * @param ctx   传递的上下文信息
     * @throws Exception Exception
     */
    public static void deleteNode(ZooKeeper zooKeeper, final String path, int version, AsyncCallback.VoidCallback callback, Object ctx) throws Exception {
        zooKeeper.delete(path,version);
    }
}

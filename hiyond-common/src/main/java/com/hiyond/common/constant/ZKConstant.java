package com.hiyond.common.constant;

import com.hiyond.common.properties.PropertiesUtil;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * Created by hiyond on 2016/10/21.
 */
public class ZKConstant {
    private final static Logger LOG = Logger.getLogger(ZKConstant.class);

    public final static String ZK_SERVER;

    static {
        LOG.info("加载zookeeper配置");
        Properties properties = PropertiesUtil.getProperties(Constant.ZK_PROPERTIES_PATH);
        ZK_SERVER = properties.getProperty("zookeeper.server");
    }

    public static void main(String[] args) {
        System.out.println(ZK_SERVER);
    }
}

package com.hiyond.common.properties;

import com.hiyond.common.constant.Constant;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by hiyond on 2016/9/21.
 */
public class MongoProperties {

    public static final String MONGO_URL;

    public static final String MONGO_PORT;

    public static final String MONGO_DATABASE;

    static {
        Properties properties = PropertiesUtil.getProperties(Constant.MONGO_PROPERTIES_PATH);
        MONGO_URL = properties.getProperty("mongo.url");
        MONGO_PORT = properties.getProperty("mongo.port");
        MONGO_DATABASE = properties.getProperty("mongo.database");
    }

    public static void main(String[] args) {
        System.out.println(MONGO_URL);
        System.out.println(MONGO_PORT);
        System.out.println(MONGO_DATABASE);
    }

}

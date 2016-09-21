package com.hiyond.common.mongodb;

import com.hiyond.common.properties.MongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

/**
 * Created by hiyond on 2016/9/21.
 */
public class MongoCenter {

    private static Logger logger = Logger.getLogger(MongoCenter.class);

    private MongoCenter() {
    }

    public static MongoDatabase getMongoDatabase() {
        logger.info("加载MongoDatabase");
        try {
            MongoClient mongoClient = new MongoClient(MongoProperties.MONGO_URL,NumberUtils.toInt(MongoProperties.MONGO_PORT));
            return mongoClient.getDatabase(MongoProperties.MONGO_DATABASE);
        }catch (Exception e){
            logger.error("加载MongoDatabase失败："+e);
        }
        return null;
    }

    public static void main(String[] args) {
        getMongoDatabase();
    }
}

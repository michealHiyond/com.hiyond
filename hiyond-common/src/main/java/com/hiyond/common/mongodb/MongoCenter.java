package com.hiyond.common.mongodb;

import com.hiyond.common.properties.MongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;


public class MongoCenter {

    private static Logger logger = Logger.getLogger(MongoCenter.class);

    private static MongoClient mongoClient = null;

    private MongoCenter() {
    }

    static {
        initMongoClient();
    }

    public static MongoDatabase getMongoDatabaseByDefaultDb() {
        logger.info("加载MongoDatabase");
        try {
            return mongoClient.getDatabase(MongoProperties.MONGO_DATABASE);
        }catch (Exception e){
            logger.error("加载MongoDatabase失败："+e);
        }
        return null;
    }

    public static MongoDatabase getMongoDatabaseByDb(String dbName) {
        logger.info("加载MongoDatabase");
        try {
            return mongoClient.getDatabase(dbName);
        }catch (Exception e){
            logger.error("加载MongoDatabase失败："+e);
        }
        return null;
    }

    private static void initMongoClient() {
        try {
            mongoClient = new MongoClient(MongoProperties.MONGO_URL,NumberUtils.toInt(MongoProperties.MONGO_PORT));
        }catch (Exception e){
            logger.error("加载MongoClient失败："+e);
        }
    }

    public static void closeMongoClient() {
        if(mongoClient != null){
            mongoClient.close();
        }
    }

}

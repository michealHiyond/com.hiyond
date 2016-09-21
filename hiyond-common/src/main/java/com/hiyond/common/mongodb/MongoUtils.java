package com.hiyond.common.mongodb;

import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

/**
 * Created by hiyond on 2016/9/21.
 */
public class MongoUtils {

    private static Logger logger = Logger.getLogger(MongoUtils.class);

    private static final boolean SUCCESS = true;
    private static final boolean FAILD = false;

    public static boolean insertCollection(Document document, String collectionName) {
        try {
            MongoDatabase database = MongoCenter.getMongoDatabase();
            database.getCollection(collectionName).insertOne(document);
            return SUCCESS;
        }catch (Exception e){
            logger.error("插入失败，参数{},{},{}"+document+collectionName,e);
            return FAILD;
        }
    }
}

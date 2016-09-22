package com.hiyond.common.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.List;

public class MongoUtils {

    private static Logger logger = Logger.getLogger(MongoUtils.class);

    private static final boolean SUCCESS = true;
    private static final boolean FAILD = false;

    /**
     *创建集合
     */
    public static boolean createCollection(String collectionName) throws Exception{
        try {
            MongoDatabase database = MongoCenter.getMongoDatabaseByDefaultDb();
            database.createCollection(collectionName);
            return SUCCESS;
        }catch (Exception e){
            logger.error("创建集合失败集合名称："+collectionName+"："+e);
            return FAILD;
        }
    }

    /**
     * 集合插入数据
     * @param document
     * @param collectionName
     */
    public static boolean insertCollection(Document document, String collectionName) {
        try {
            MongoDatabase database = MongoCenter.getMongoDatabaseByDefaultDb();
            database.getCollection(collectionName).insertOne(document);
            return SUCCESS;
        }catch (Exception e){
            logger.error("插入失败，参数{},{},{}"+document+collectionName,e);
            return FAILD;
        }
    }

    public static boolean insertCollection(List<Document> documents, String collectionName) {
        try {
            MongoDatabase database = MongoCenter.getMongoDatabaseByDefaultDb();
            database.getCollection(collectionName).insertMany(documents);
            return SUCCESS;
        }catch (Exception e){
            logger.error("插入失败，参数{},{},{}"+documents+collectionName,e);
            return FAILD;
        }
    }

    public static void dropCollection(String name) {
        MongoDatabase database = MongoCenter.getMongoDatabaseByDefaultDb();
        database.getCollection(name).drop();
    }

    public static FindIterable<Document> queryDocument(String collectionName, BasicDBObject filters, Integer limit) {
        MongoDatabase database = MongoCenter.getMongoDatabaseByDefaultDb();
        FindIterable<Document> findIterable = database.getCollection(collectionName).find();
        if(filters != null){
            findIterable = findIterable.filter(filters);
        }
        if(limit != null){
            findIterable = findIterable.limit(limit);
        }
        return findIterable;
    }

}

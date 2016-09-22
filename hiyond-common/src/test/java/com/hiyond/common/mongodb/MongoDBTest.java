package com.hiyond.common.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.Document;
import org.hibernate.annotations.SourceType;

import javax.sound.midi.Soundbank;
import java.util.Map;

/**
 * Created by hiyond on 2016/9/21.
 */
public class MongoDBTest {

    public static void main(String[] args) throws Exception {
        String collectionName = "hiyond";
        MongoUtils.dropCollection(collectionName);
        boolean flag = MongoUtils.createCollection(collectionName);
        System.out.println(flag);

        Map<String, Object> map = new HashedMap();
        map.put("title","测试");
        map.put("name","hiyond");
        flag = MongoUtils.insertCollection(new Document(map), collectionName);
        System.out.println(flag);

        FindIterable<Document> findIterable = MongoUtils.queryDocument(collectionName,null,null);
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            JSONObject jsonObject = JSONObject.fromObject(mongoCursor.next().toJson());
            System.out.println(jsonObject.get("_id"));
            System.out.println(jsonObject.get("title"));
            System.out.println(jsonObject.get("name"));
        }
    }


}

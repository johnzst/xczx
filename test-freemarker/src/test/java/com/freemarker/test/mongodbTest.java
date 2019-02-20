package com.freemarker.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class mongodbTest {

    public static void main(String[] args) {
        // 创建mongodb 客户端
        MongoClient mongoClient = new MongoClient("localhost",27017);
        // 链接数据库
        MongoDatabase database = mongoClient.getDatabase("xc_cms");
        // 链接colletion
        MongoCollection<Document> user_test = database.getCollection("user_test");
        // 查询第一个文档
        Document myDoc = user_test.find().first();
        // 得到文档内容json 串
        String json = myDoc.toJson();
        System.out.println(json);

    }
}

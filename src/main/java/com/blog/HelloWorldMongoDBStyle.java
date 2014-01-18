package com.blog;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by ashik on 1/18/14 5:37 PM.
 */
public class HelloWorldMongoDBStyle {
    public static void  main(String args[]) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        DB database = client.getDB("test");
        DBCollection collection = database.getCollection("names");

        DBObject document = collection.findOne();
        System.out.println(document);
    }
}

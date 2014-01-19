package com.blog;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * Created by ashik on 1/18/14 8:43 PM.
 */
public class HelloWorldMongoDBSparkFreeMarkerStyle {

    public static void main(String args[]) throws UnknownHostException {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldMongoDBSparkFreeMarkerStyle.class, "/");

        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        final DB database = client.getDB("test");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template template = configuration.getTemplate("hello.ftl");
                    DBCollection collection = database.getCollection("names");
                    DBObject document = collection.findOne();

                    template.process(document, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}

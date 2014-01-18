package com.blog;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by ashik on 1/18/14 5:59 PM.
 */
public class HelloWorldSparkStyle {
    public static void main(String args[]) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From Spark";
            }
        });
    }
}

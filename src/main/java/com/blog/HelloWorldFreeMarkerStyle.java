package com.blog;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashik on 1/18/14 8:00 PM.
 */
public class HelloWorldFreeMarkerStyle {
    public static void main(String args[]) {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkStyle.class, "/");

        try {
            Template template = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "FreeMarker");

            template.process(helloMap, writer);
            System.out.println(writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}

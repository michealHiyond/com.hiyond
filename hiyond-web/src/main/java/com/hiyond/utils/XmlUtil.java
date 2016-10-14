package com.hiyond.utils;

import com.hiyond.entity.User;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.lang.reflect.Field;

public class XmlUtil {

    @Test
    public void test() {
        User user = new User();
        user.setName("123");
        user.setPassword("456");
        Document document = (Document) beanToXml(user);
        System.out.println(document.asXML());
    }


    public <T> T beanToXml(T t) {
        Document document = null;
        try {
            Class cla = t.getClass();
            document = DocumentHelper.createDocument();
            String rootName = cla.getSimpleName();
            Element element = document.addElement(rootName.toLowerCase());
            Field[] fields = cla.getDeclaredFields();
            for (int i = 0; i < fields.length; i++){
                String obj = null;
                fields[i].setAccessible(true);
                if(fields[i].get(t) != null){
                    obj = fields[i].get(t).toString();
                    element.addElement(fields[i].getName()).setText(obj);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return (T) document;

    }


}

package com.hiyond.utils;

import com.hiyond.entity.User;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class XmlUtil {

    @Test
    public void test() {
        User user = new User();
        user.setName("123");
        user.setPassword("456");
        Document document = beanToDocument(user,false);
        System.out.println(document.asXML());
    }


    public Document beanToDocument(User user, boolean skipEmptyElement) {
        Document document = null;
        try {
            Class cla = user.getClass();
            document = DocumentHelper.createDocument();
            String rootName = cla.getSimpleName();
            Element element = document.addElement(rootName.toLowerCase());
            Field[] fields = cla.getDeclaredFields();
            for (int i = 0; i < fields.length; i++){
                String obj = null;
                fields[i].setAccessible(true);
                if(fields[i].get(user) != null){
                    obj = fields[i].get(user).toString();
                    element.addElement(fields[i].getName()).setText(obj);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return document;

    }


}

package com.hiyond.utils;

import com.hiyond.common.utils.XmlUtil;
import com.hiyond.entity.User;
import org.dom4j.Document;
import org.junit.Test;

public class XmlUtil_ {

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setName("123");
        user.setPassword("456789");
        XmlUtil<User> xmlUtil = new XmlUtil<>(user);
        Document document = xmlUtil.beanToXml();
        System.out.println(document.asXML());
        xmlUtil.writeXmlDocument(document,"D://hiyond","test","UTF-8");
        XmlUtil.textParseXmlDocument(document.asXML());
    }

    public static void main(String[] args) {
        String a = "aAbBcC";
        String b = new String(a);
        System.out.println(a == b);
//        a = "哈哈";
        char[] chars = a.toCharArray();
        for (char c : chars) {
            System.out.println(c +":"+ (int) c);
        }
    }

}

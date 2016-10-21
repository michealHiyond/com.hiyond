package com.hiyond.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class XmlUtil<T> {

    private T t;

    public XmlUtil(T t) {
        this.t = t;
    }

    /**
     * bean转为xml的Document对象
     */
    public Document beanToXml() {
        Document document = null;
        try {
            Class cla = this.t.getClass();
            document = DocumentHelper.createDocument();
            String rootName = cla.getSimpleName();
            Element element = document.addElement(rootName.toLowerCase());
            Field[] fields = cla.getDeclaredFields();
            String obj;
            for(Field field : fields) {
                field.setAccessible(true);
                if(field.get(this.t) != null) {
                    obj = field.get(this.t).toString();
                    element.addElement(field.getName()).setText(obj);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * XML保存到本地
     * @param doc xml对象
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param encode 文件编码（默认UTF-8）
     * @return boolean [成功返回true,失败返回false]
     */
    public boolean writeXmlDocument(Document doc, String filePath, String fileName, String encode) {
        if(null == doc){
            throw  new NullPointerException("doc must not be null!");
        }
        if(StringUtils.isBlank(filePath)){
            throw  new NullPointerException("filePath must not be null!");
        }
        if(StringUtils.isBlank(fileName)){
            throw  new NullPointerException("fileName must not be null!");
        }
        if(StringUtils.isBlank(encode)){
            encode = "UTF-8";
        }
        XMLWriter xmlWriter = null;
        try {
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding(encode);
            String xmlPathAndName = filePath+"//"+fileName;
            if(!xmlPathAndName.endsWith(".xml") || !xmlPathAndName.endsWith(".XML")) {
                xmlPathAndName += ".xml";
            }
            File file = new File(xmlPathAndName);
            if(file.exists()){
                if(file.delete()){
                    xmlWriter = new XMLWriter(new FileWriter(file), outputFormat);
                    xmlWriter.write(doc);
                }else {
                    throw new IOException("无法删除已存在的文件："+xmlPathAndName);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(xmlWriter != null){
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * xml字符串转xml对象
     * @param xmlText xml字符串
     * @return Document xml对象
     */
    public static Document textParseXmlDocument(String xmlText) throws DocumentException {
        return DocumentHelper.parseText(xmlText);
    }

}

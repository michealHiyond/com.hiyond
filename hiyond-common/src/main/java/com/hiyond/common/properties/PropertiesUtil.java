package com.hiyond.common.properties;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 获取properties配置信息
 * 
 * @author admin
 *
 */
public class PropertiesUtil implements Serializable {

	private static final long serialVersionUID = 6646748980840604716L;

	private static Logger logger = Logger.getLogger(PropertiesUtil.class);

	public static Properties getProperties(final String path) {
		InputStream inputStream = null;
		try {
			inputStream = PropertiesUtil.class.getResourceAsStream(path);
			Properties properties = new Properties();
			properties.load(inputStream);
			return properties;
		} catch (Exception e) {
			logger.error("获取路径为：" + path + " 文件失败：", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e2) {
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Properties properties = getProperties("/mongo.properties");
		System.out.println(properties.toString());
	}
}

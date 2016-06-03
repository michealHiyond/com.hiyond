package com.hiyond.web.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import entity.User;

public class TestUser {

	@Test
	public void test01() {
		User user = new User();
		user.setId(1);
		user.setName("hiyond");
		System.out.println(user);
	}

	@Test
	public void test02() {
		try {
			Properties properties = new Properties();
			InputStream inputStream = TestUser.class.getResourceAsStream("/redis/redis.properties");
			properties.load(inputStream);
			System.out.println(properties.toString());
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

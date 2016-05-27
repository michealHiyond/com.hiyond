package test;

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

}

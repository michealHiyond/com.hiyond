package test;

import entity.User;

public class TestUser {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setName("hiyond");
		System.out.println(user);
	}
	
}

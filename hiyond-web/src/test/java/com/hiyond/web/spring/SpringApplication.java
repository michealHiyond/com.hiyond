/**
 * 
 */
package com.hiyond.web.spring;

import java.util.Date;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hiyond.entity.User;
import com.hiyond.service.UserService;
/**
 * @author hiyond
 *
 */
public class SpringApplication {

	private SpringApplication() {

	}

	private static ApplicationContext applicationContext;

	static {
		String[] springpath = { "classpath:spring/springApplication.xml" };
		applicationContext = new ClassPathXmlApplicationContext(springpath);
	}

	/**
	 * get bean by class
	 * 
	 * @param t
	 * @return
	 */
	public static <T> T getBean(Class<T> t) {
		try {
			return (T) applicationContext.getBean(t);
		} catch (NoSuchBeanDefinitionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * get bean by name
	 * @param BeanName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String BeanName) {
		try {
			return (T) applicationContext.getBean(BeanName);
		} catch (NoSuchBeanDefinitionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		UserService userService = getBean(UserService.class);
		int count = userService.findUserByName("123456");
		System.out.println(count);
//		System.out.println(userService.loginUser(new User()));
		User user = new User();
		user.setName("123456");
		user.setLastLoginTime(new Date());
		System.out.println(user);
		Integer result = userService.updateUserLoginTime(user);
		System.out.println(result);
		System.out.println(new User() instanceof User);
	}
	
}

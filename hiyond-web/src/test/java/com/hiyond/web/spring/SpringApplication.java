/**
 * 
 */
package com.hiyond.web.spring;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

	public static void main(String[] args) {
		UserService userService = getBean("userService");
		System.out.println(userService.toString());
	}
	
}

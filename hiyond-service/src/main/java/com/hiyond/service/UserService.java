package com.hiyond.service;

import org.apache.ibatis.annotations.Param;

import com.hiyond.entity.User;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Hiyond
 *        
 */
public interface UserService {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User loginUser(@Param("user") User user) throws Exception;
	
	/**
	 * 插入数据
	 * @param user
	 * @throws Exception
	 */
	@Transactional
	@Order(2)
	void insertUser(@Param("user") User user) throws Exception;

	/**
	 * 更新数据
	 * 
	 * @param user
	 * @throws Exception
	 */
	Integer updateUserLoginTime(@Param("user") User user) throws Exception;

	/**
	 * 根据用户名查找
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	int findUserByName(String userName) throws Exception;
}

package com.hiyond.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.hiyond.dao.mapper.base.BaseMapper;
import com.hiyond.entity.User;

public interface UserMapper extends BaseMapper {

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
	void insertUser(@Param("user") User user) throws Exception;

	/**
	 * 更新数据
	 * 
	 * @param user
	 * @throws Exception
	 */
	void updateUserLoginTime(@Param("user") User user) throws Exception;

	/**
	 * 根据用户名查找
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	int findUserByName(@Param("userName") String userName) throws Exception;
	
}

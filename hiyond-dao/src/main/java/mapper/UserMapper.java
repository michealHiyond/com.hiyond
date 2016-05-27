package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;
import mapper.base.BaseMapper;

public interface UserMapper extends BaseMapper {

	/**
	 * 查询符合条件的个数
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int querySum(@Param("user") User user) throws Exception;

	/**
	 * 查询符合条件的集合
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<User> queryUser(@Param("user") User user) throws Exception;

	/**
	 * 查询符合条件的个数
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User findUser(@Param("user") User user) throws Exception;

	/**
	 * 插入数据
	 * 
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
	void updateUser(@Param("user") User user) throws Exception;

}

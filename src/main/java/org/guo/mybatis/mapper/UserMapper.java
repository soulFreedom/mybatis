package org.guo.mybatis.mapper;

import java.util.List;

import org.guo.mybatis.modle.User;
import org.guo.mybatis.modle.UserCustom;
import org.guo.mybatis.modle.UserQueryVo;

public interface UserMapper {
	
	//用户信息复杂条件综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//查找用户数量
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查找用户
	public User findUserById(int id) throws Exception;
	
	//根据id查询用户信息，使用resultMap作为输出。
	public User findUserByIdResultMap(int id) throws Exception;
	
	//插入用户
	public void insertUser(User user) throws Exception;
	
	//根据名称查找用户
	public List<User> findUserByName(String name) throws Exception;
	
	//修改用户
	public void updateUser(User user) throws Exception;
	
}

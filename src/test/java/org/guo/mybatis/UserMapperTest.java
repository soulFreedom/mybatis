package org.guo.mybatis;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.guo.mybatis.mapper.UserMapper;
import org.guo.mybatis.modle.User;
import org.guo.mybatis.modle.UserCustom;
import org.guo.mybatis.modle.UserQueryVo;

import junit.framework.TestCase;

public class UserMapperTest extends TestCase {
	
	private SqlSession sqlSession = null;
	
	public void findUserCount() throws Exception {
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom  userCustom = new UserCustom();
		userCustom.setEmail("a@123");
		userCustom.setUserName("a");
		userQueryVo.setUserCustom(userCustom);
		
		int count   = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}
	
	//根据id主键查询用户
	public void findUserList() throws Exception{
		
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom  userCustom = new UserCustom();
//		userCustom.setEmail("a@123");
		userCustom.setUserName("b");
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
//		ids.add(3);
		ids.add(4);
		
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> userCustomList  = userMapper.findUserList(userQueryVo);
		System.out.println(userCustomList);
	}
	
	//根据id主键查询用户
	public void findUserById() throws Exception{
		/*try {
			sqlSession = MyBaitsUtil.getSqlSession();
			//第一个参数：映射文件中statement的id，= namespace + "." + statement的  id
			//第二个参数：指定和映射文件中所匹配的parameterType类型的对象
			//sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象。
			User  user = sqlSession.selectOne("test.findUserById", 1);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放会话资源
			if (sqlSession != null)
				sqlSession.close();
		}*/
		
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
	}
	
	//根据id主键查询用户,使用resultMap作为返回。
	public void findUserByIdResultMap() throws Exception{
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println(user);
		
	}
	
	//根据用户名称模糊查询用户信息，可能返回多条
	public void findUserByName() throws Exception {
		/*sqlSession = MyBaitsUtil.getSqlSession();
		//List当中的User 和映射文件中resultType所指定的类型一致。
		//selectList可以代替selectOne 但是反过来不可以，会报错。
		List<User> users = sqlSession.selectList("test.findUserByName", "a");*/
		
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> users = userMapper.findUserByName("a");
		
		System.out.println(users);
	}
	
	//新增用户信息
	public void insertUser() throws Exception {
		/*sqlSession = MyBaitsUtil.getSqlSession();
		
		User user = new User();
		user.setUserName("Robin");
		user.setPassword("123");
		user.setEmail("a@123");
		user.setInTime(new Timestamp(System.currentTimeMillis()));
		
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit(); //默认是false 不提交。
		sqlSession.close();*/
		
		//使用Mapper代理的方式調用
		sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUserName("ddd");
		user.setPassword("123");
		user.setEmail("a@123");
		user.setInTime(new Timestamp(System.currentTimeMillis()));
		
		userMapper.insertUser(user);
		sqlSession.commit();
	}
	
	//新增用户信息
	public void deleteUser() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		
		User user = new User();
		user.setId(13);
		
		sqlSession.insert("test.deleteUser", user);
		sqlSession.commit(); //默认是false 不提交。
		sqlSession.close();
		
	}
	
	//新增用户信息
	public void updateUser() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		
		User user = new User();
		user.setId(12);
		user.setUserName("Lady");
		user.setEmail("hello");
		
		sqlSession.update("test.updateUser", user);
		sqlSession.commit(); //默认是false 不提交。
		sqlSession.close();
		
	}
	
	//測試一級緩存
	public void testCache1() throws Exception{
		SqlSession sqlSession = MyBaitsUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//下边查询使用一个SqlSession
		//第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
//		如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
		
		//更新user1的信息
		user1.setUserName("dav");
		userMapper.updateUser(user1);
		//执行commit操作去清空缓存
		sqlSession.commit();
		
		//第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
		
	}
	
	//测试二级缓存
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = MyBaitsUtil.getSqlSession();
		SqlSession sqlSession2 = MyBaitsUtil.getSqlSession();
		SqlSession sqlSession3 = MyBaitsUtil.getSqlSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		
		//第一次发起查询
		User user1 = userMapper1.findUserById(1);
		//这里执行关闭操作，将sqlsession中的数据写到二级缓存区域。不关闭写不到二级缓存。
		sqlSession1.close(); 
		System.out.println(user1);
		
		//使用sqlSession3执行commit操作。
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user = userMapper3.findUserById(1);
		user1.setUserName("Dav");
		
		userMapper3.updateUser(user);
		sqlSession3.commit();
		
		//第二次发起查询
		User user2 = userMapper2.findUserById(1);
		sqlSession2.close();
		System.out.println(user2);
		
	}
}

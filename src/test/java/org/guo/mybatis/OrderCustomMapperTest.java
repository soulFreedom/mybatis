package org.guo.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.guo.mybatis.mapper.OrderCustomMapper;
import org.guo.mybatis.mapper.UserMapper;
import org.guo.mybatis.modle.Order;
import org.guo.mybatis.modle.OrderCustom;
import org.guo.mybatis.modle.User;

import junit.framework.TestCase;

public class OrderCustomMapperTest extends TestCase {
	private SqlSession sqlSession = null;
	
	//查询订单关联的用户信息。
	public void findOrderUser() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		OrderCustomMapper  orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<OrderCustom> orderCustoms = orderCustomMapper.findOrderUser();
		
		System.out.println(orderCustoms);
	}
	
	//查询订单关联的用户信息。使用ResultMap
	public void findOrderUserResultMap() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		OrderCustomMapper  orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Order> orderCustoms = orderCustomMapper.findOrderUserResultMap();
		
		System.out.println(orderCustoms);
	}
	
	//查询订单关联的用户信息。使用ResultMap
	public void findOrderAndOrderDetailResultMap() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		OrderCustomMapper  orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Order> orderCustoms = orderCustomMapper.findOrderAndOrderDetailResultMap();
		
		System.out.println(orderCustoms);
	}
	
	//查询用户关联的商品信息。使用ResultMap
	public void findUserAndItemsResultMap() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		OrderCustomMapper  orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<User> orderCustoms = orderCustomMapper.findUserAndItemsResultMap();
		
		System.out.println(orderCustoms);
	}
	
	//查查询订单关联的用户信息，实现延迟加载。
	public void findOrderUserLazyLoading() throws Exception {
		sqlSession = MyBaitsUtil.getSqlSession();
		OrderCustomMapper  orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Order> orders = orderCustomMapper.findOrderUserLazyLoading();
		
		for (Order order : orders) {
			User user = order.getUser();
			System.out.println(user);
		}
		
	}
}

package org.guo.mybatis.mapper;

import java.util.List;

import org.guo.mybatis.modle.Order;
import org.guo.mybatis.modle.OrderCustom;
import org.guo.mybatis.modle.User;

/**
 * 订单mapper
 * @author pc
 *
 */
public interface OrderCustomMapper {
	
	//查询订单关联的用户信息。
	public List<OrderCustom> findOrderUser() throws Exception; 
	
	//查询订单关联的用户信息。使用resultMap
	public List<Order> findOrderUserResultMap() throws Exception; 
	
	//查询订单关联的订单明细信息。使用resultMap
	public List<Order> findOrderAndOrderDetailResultMap() throws Exception; 
	
	//查询用户购买的商品信息。使用resultMap
	public List<User> findUserAndItemsResultMap() throws Exception; 
	
	//查询订单关联的用户信息，实现延迟加载。
	public List<Order> findOrderUserLazyLoading() throws Exception; 
	
}

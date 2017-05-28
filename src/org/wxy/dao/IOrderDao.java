package org.wxy.dao;

import java.util.List;

import org.wxy.entity.Order;


public interface IOrderDao {

	/**
	 * 
	 * @param pageSize每页的条数
	 * @param pageNum第几页
	 * @param id用户id
	 * @return用户的订单集合
	 */
	public List<Order> getOrdersPageList(int pageSize, int pageNum,String id);
	/**
	 * 添加购物车信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addOrders(Order item);
	/**
	 * 根据id删除订单
	 * @param id订单id
	 * @return
	 */
	public int delOrder(int id);
}

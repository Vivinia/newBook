package org.wxy.dao;

import java.util.List;

import org.wxy.entity.Car;


public interface ICarDao {
	/**
	 * 取得购物车分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Car> getCarsPageList(int pageSize, int pageNum,String id);
	/**
	 * 添加购物车信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addCars(Car item);
	/**
	 * 根据id删除购物车信息
	 * @param id
	 * @return
	 */
	public int delCars(String id);
	
	/**
	 * 
	 * @param userId用户id
	 * @param bookId书籍id
	 * @return根据用户和书籍查询购物中是否存放记录
	 */
	public Car getCarByUserAndBook(int userId,int bookId);
	
	/**
	 * 删除所有购物车信息
	 * @return
	 */
	public int delAllCars();

}

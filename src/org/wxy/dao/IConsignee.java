package org.wxy.dao;

import java.util.List;

import org.wxy.entity.Consignee;

public interface IConsignee {
	/**
	 * 取得书籍分页信息
	 * 
	 * @param pageSize
	 *            每个分页的记录数
	 * @param pageNum
	 *            当前要获取分页页码
	 * @return
	 */
	public List<Consignee> getConsigneesPageList(int pageSize, int pageNum);

	/**
	 * 取得收货对象信息，用于后台管理修改前的查询
	 * 
	 * @param id
	 * @return
	 */
	public Consignee getConsigneesItem(String id);

	/**
	 * 添加收货信息
	 * 
	 * @param item
	 *            对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addConsignees(Consignee item);

	/**
	 * 修改收货信息
	 * 
	 * @param item
	 *            要修改的对象
	 * @return
	 */
	public void editConsignees(Consignee item);

	/**
	 * 删除收货信息
	 * 
	 * @param id
	 * @return
	 */
	public int delConsignees(int id);
	
	/**
	 * 根据userId获取收货信息
	 * @param userId
	 * @return
	 */
	public List<Consignee> getConsigneeByUserId(int userId);
	
	/**
	 * 根据收货id获取consigne信息
	 * @param ConsigneeId
	 * @return
	 */
	public Consignee getOneConsignee(int consigneeId);

}

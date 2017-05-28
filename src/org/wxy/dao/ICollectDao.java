package org.wxy.dao;

import java.util.List;

import org.wxy.entity.Collect;

public interface ICollectDao {
	/**
	 * 
	 * @return全部的收藏集合
	 */
	public List<Collect> getAllCollect(int pageSize, int pageNum,String id);
	
	/**
	 * 
	 * @param collect要添加的collect对象
	 */
	public void addCollect(Collect collect);
	/**
	 * 
	 * @param id根据id删除收藏信息
	 */
	public int deleteCollect(String id);

}

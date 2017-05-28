package org.wxy.dao;

import java.util.List;

import org.wxy.entity.Book;

/**
 * 管理员数据操作接口
 */
public interface IBookDao {
	/**
	 * 取得书籍分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Book> getBooksPageList(int pageSize, int pageNum);
	/**
	 * 取得书籍对象信息，用于后台管理修改前的查询
	 * @param id
	 * @return
	 */
	public Book getBooksItem(String id);
	/**
	 * 添加书籍信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addBooks(Book item);
	/** 
	 * 修改书籍信息
	 * @param item 要修改的对象
	 * @return
	 */
	public void editBooks(Book item);
	/**
	 * 删除书籍信息
	 * @param id
	 * @return
	 */
	public int delBooks(int id);
	/**
	 * 根据书籍名称查询书籍信息
	 * @param name书籍名称
	 * @return
	 */
	public Book getBooksItemByName(String name);
}

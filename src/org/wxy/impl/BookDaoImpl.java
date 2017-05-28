package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.IBookDao;
import org.wxy.entity.Book;

public class BookDaoImpl implements IBookDao{

	/**
	 * 添加书籍信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addBooks(Book item) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			session.save(item);
			tran.commit();//执行事务
		} catch (Exception e) {
			tran.rollback();//回滚事务
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 删除书籍信息
	 * @param id
	 * @return
	 */
	public int delBooks(int id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Book where BookId=?";
			Query q=session.createQuery(hql);
			q.setInteger(0,id);
			iRow=q.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return iRow;
	}

	/** 
	 * 修改书籍信息
	 * @param item 要修改的对象
	 * @return
	 */
	public void editBooks(Book item) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			session.update(item);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 取得书籍对象信息，用于后台管理修改前的查询
	 * @param id
	 * @return
	 */
	public Book getBooksItem(String id) {
		Book book=null;
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Book where bookId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
			book=(Book) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return book;
	}

	/**
	 * 取得书籍分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Book> getBooksPageList(int pageSize, int pageNum) {
		List<Book> bookList=new ArrayList<Book>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Book order by id desc";
			Query q=session.createQuery(hql);
			q.setFirstResult((pageNum-1)*pageSize);//过滤掉前边pageNum-1页
			q.setMaxResults(pageSize);//获取pageSize条记录
			bookList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return bookList;
	}

	/**
	 * 根据书籍名称查询书籍信息
	 */
	public Book getBooksItemByName(String name) {
		Book book=null;
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Book where bookName=?";
			Query q=session.createQuery(hql);
			q.setString(0,name);
			book=(Book) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return book;
	}
}

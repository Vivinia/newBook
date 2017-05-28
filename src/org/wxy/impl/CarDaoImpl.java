package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.ICarDao;
import org.wxy.entity.Car;
import org.wxy.entity.User;

public class CarDaoImpl implements ICarDao{

	/**
	 * 添加购物车信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addCars(Car item) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			session.save(item);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 删除购物车信息
	 * @param id
	 * @return
	 */
	public int delCars(String id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Car where carBookId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
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
	 * 取得购物车分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Car> getCarsPageList(int pageSize, int pageNum,String id) {
		List<Car> carList=new ArrayList<Car>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Car where carUserId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
			q.setFirstResult((pageNum-1)*pageSize);//过滤掉前边pageNum-1页
			q.setMaxResults(pageSize);//获取pageSize条记录
			carList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return carList;
	}

	/**
	 * 
	 * @param userId用户id
	 * @param bookId书籍id
	 * @return根据用户和书籍查询购物中是否存放记录
	 */
	public Car getCarByUserAndBook(int userId, int bookId) {
		Car car=new Car();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Car where carUserId=? and carBookId=?";
			Query q=session.createQuery(hql);
			q.setInteger(0,userId);
			q.setInteger(1,bookId);
			car=(Car) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return car;
	}

	/**
	 * 删除所有购物车信息
	 */
	public int delAllCars() {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Car";
			Query q=session.createQuery(hql);
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

}

package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.IOrderDao;
import org.wxy.entity.Collect;
import org.wxy.entity.Order;

public class OrderDaoImpl implements IOrderDao{

	public void addOrders(Order item) {
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

	public List<Order> getOrdersPageList(int pageSize, int pageNum, String id) {
		List<Order> orderList=new ArrayList<Order>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Order where orderConsigneeId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
			q.setFirstResult((pageNum-1)*pageSize);//过滤掉前边pageNum-1页
			q.setMaxResults(pageSize);//获取pageSize条记录
			orderList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return orderList;
	}

	public int delOrder(int id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Order where orderId=?";
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

}

package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.IConsignee;
import org.wxy.entity.Consignee;

public class ConsigneeDaoImpl implements IConsignee{

	public void addConsignees(Consignee item) {
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

	public int delConsignees(int id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Consignee where consigneeId=?";
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

	public void editConsignees(Consignee item) {
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
	 * 获取用户的第一条收货信息
	 * 
	 * @param id
	 * @return
	 */
	public Consignee getConsigneesItem(String id) {
		Consignee consignee=null;
		List<Consignee> consigneeList;
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Consignee where consigneeUserId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
			consigneeList=q.list();
			consignee=consigneeList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return consignee;
	}

	public List<Consignee> getConsigneesPageList(int pageSize, int pageNum) {
		return null;
	}

	/**
	 * 根据userId获取收货信息
	 * @param userId
	 * @return
	 */
	public List<Consignee> getConsigneeByUserId(int userId) {
		List<Consignee> consigneeList=new ArrayList<Consignee>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Consignee where consigneeUserId=?";
			Query q=session.createQuery(hql);
			q.setInteger(0,userId);
			consigneeList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return consigneeList;
	}

	public Consignee getOneConsignee(int consigneeId) {
		Consignee consignee=null;
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Consignee where consigneeId=?";
			Query q=session.createQuery(hql);
			q.setInteger(0,consigneeId);
			consignee=(Consignee) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return consignee;
	}

}

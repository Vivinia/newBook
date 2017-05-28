package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.ICollectDao;
import org.wxy.entity.Collect;

public class CollectDaoImpl implements ICollectDao{

	/**
	 * 
	 * @param collect要添加的collect对象
	 */
	public void addCollect(Collect collect) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			session.save(collect);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 * 
	 * @return全部的收藏集合
	 */
	public List<Collect> getAllCollect(int pageSize, int pageNum,String id) {
		List<Collect> collectList=new ArrayList<Collect>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from Collect where CollectUserId=?";
			Query q=session.createQuery(hql);
			q.setString(0,id);
			q.setFirstResult((pageNum-1)*pageSize);//过滤掉前边pageNum-1页
			q.setMaxResults(pageSize);//获取pageSize条记录
			collectList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return collectList;
	}

	/**
	 * 根据id删除收藏信息
	 */
	public int deleteCollect(String id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from Collect where collectBookId=?";
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

}

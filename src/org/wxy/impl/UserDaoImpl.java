package org.wxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.IUserDao;
import org.wxy.entity.User;

public class UserDaoImpl implements IUserDao {

	public User getUserByUnameAndUpass(String uname, String upass) {
		User user = null;
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where userName=? and userPass=?";
		Query q = session.createQuery(hql);
		q.setString(0, uname);
		q.setString(1, upass);
		user = (User) q.uniqueResult();
		session.close();
		return user;
	}

	public void addUser(User user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(user);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public List<User> getAllUser(int pageSize, int pageNum) {
		List<User> userList=new ArrayList<User>();
		Session session=HibernateSessionFactory.getSession();
		try {
			String hql="from User where userId>1";
			Query q=session.createQuery(hql);
			q.setFirstResult((pageNum-1)*pageSize);
			q.setMaxResults(pageSize);
			userList=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return userList;
	}

	public int delUser(int id) {
		int iRow=0;
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			String hql="delete from User where userId=?";
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
	 * 
	 * @param name用户名字
	 * @return用户信息
	 */
	public User getUserByName(String name) {
		User user = null;
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where userName=?";
		Query q = session.createQuery(hql);
		q.setString(0, name);
		user = (User) q.uniqueResult();
		session.close();
		return user;
	}

	/**
	 * 修改用户信息
	 */
	public void updateUser(User user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try {
			session.update(user);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}

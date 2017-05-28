package org.wxy.dao;

import java.util.List;

import org.wxy.entity.User;

public interface IUserDao {

	/**
	 * 
	 * @param uname登录用户名
	 * @param upass登陆密码
	 * @return登陆后user登录成功的用户
	 */
	public User getUserByUnameAndUpass(String uname,String upass);
	/**
	 * 
	 * @param user想要添加的用户信息
	 */
	public void addUser(User user);
	/**
	 * 
	 * @param id用户id
	 * @return根据id删除用户
	 */
	public int delUser(int id);
	/**
	 * 
	 * @return查询所有的用户集合
	 */
	public List<User> getAllUser(int pageSize, int pageNum);
	
	/**
	 * 
	 * @param name用户名字
	 * @return用户信息
	 */
	public User getUserByName(String name);
	
	/**
	 * 
	 * @param user 修改后的user信息
	 * @return
	 */
	public void updateUser(User user);
}

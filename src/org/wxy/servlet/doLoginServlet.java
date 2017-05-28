package org.wxy.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wxy.dao.IUserDao;
import org.wxy.entity.User;
import org.wxy.impl.UserDaoImpl;

public class doLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		//1.接收数据请求
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		//2.判断数据的合法性
		if(uname!=null&&!"".equals(uname)&&upass!=null&&!"".equals(upass)){
			//3.调用业务
			IUserDao dao=new UserDaoImpl();
			User user=dao.getUserByUnameAndUpass(uname, upass);
			//4.转向
			if(user!=null){
				HttpSession session=request.getSession();
				session.setAttribute("user",user);
				session.setAttribute("uname",uname);
				session.setAttribute("upass",upass);
				
				//记住密码
				String[] remenber=request.getParameterValues("remenber");     //获取checkbox的值，返回的为字符串数组
		  		if(remenber!=null&&remenber.length>0){                        //如果选择了checkbox，则字符串数组不为空，长度大于0
		  			String username=URLEncoder.encode(request.getParameter("uname"),"utf-8");        //为用户名创建字符串并转码，防止中文出现错误
		  			String userpass=request.getParameter("upass");              //密码不为中文，所以密码可以不转码
		  			Cookie usernameCookie=new Cookie("username",username);         //Cookie是一个键值对，类似于map，创建一个Cookie保存用户名
		  			Cookie userpassCookie=new Cookie("userpass",userpass);         //创建一个Cookie保存密码
		  			usernameCookie.setMaxAge(864000);                              //设置用户名Cookie的保存时间，十天
		  			userpassCookie.setMaxAge(864000);                              //设置密码Cookie的保存时间，十天
		  			response.addCookie(usernameCookie);                            //将新创建的用户名Cookie添加到Cookie列表中
		  			response.addCookie(userpassCookie);                            //将新创建的密码Cookie添加到Cookie列表中
		  		}else{                      //如果没有选择记住密码
		  			Cookie[] cookies=request.getCookies();            //获取Cookie的对象
		  			if(cookies!=null&&cookies.length>0){              //如果Cookie对象不为空，说明曾经保存过用户名和密码
		  				for(Cookie c:cookies){                        //遍历Cookie对象
		  					if(c.getName().equals("username")||c.getName().equals("userpass")){       //c.getName代表Cookie的第一个元素，类似于键值对的键
		  						c.setMaxAge(0);           //如果查找到原先保存过该用户名和密码，将它们的有效时间设置为0，马上失效，相当于不保存
		  						response.addCookie(c);    //重新保存Cookie对象，否则不会起作用
		  					}
		  				}
		  			}
		 		}
				
				response.sendRedirect("bookListServlet");
			}else{
				if(uname.equals("wxy"))
					response.sendRedirect("adminLogin.jsp");
				else
					response.sendRedirect("login.jsp");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wxy.dao.IBookDao;
import org.wxy.dao.ICarDao;
import org.wxy.dao.ICollectDao;
import org.wxy.entity.Book;
import org.wxy.entity.Car;
import org.wxy.entity.Collect;
import org.wxy.entity.User;
import org.wxy.impl.BookDaoImpl;
import org.wxy.impl.CarDaoImpl;
import org.wxy.impl.CollectDaoImpl;

public class addCollectServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addCollectServlet() {
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
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");//获取存储的user信息
		
		//验证登录
		if(user==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);//转发，send开头为重定向
			return;
		}
		
		IBookDao bookdao=new BookDaoImpl();
		String carBookId=request.getParameter("bookId");//获取bookid
		Book book=bookdao.getBooksItem(carBookId);//根据book的id查询bok的全部信息
		
		Collect collect=new Collect();
		collect.setUser(user);
		collect.setBook(book);
		
		ICollectDao collectdao=new CollectDaoImpl();
		collectdao.addCollect(collect);
		
		out.println("<script type='text/javascript'>");
		out.println("alert('收藏成功');");
		out.println("</script>");
		
		
		response.sendRedirect("bookListServlet");
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

package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wxy.dao.IBookDao;
import org.wxy.entity.Book;
import org.wxy.entity.User;
import org.wxy.impl.BookDaoImpl;

public class bookListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public bookListServlet() {
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
		IBookDao dao=new BookDaoImpl();
		List<Book> bookList=dao.getBooksPageList(20,1);
		request.setAttribute("BookList",bookList);
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null)
			request.getRequestDispatcher("allbook.jsp").forward(request, response);//转发，send开头为重定向
		else if(user.getUserName().equals("wxy"))
			request.getRequestDispatcher("book.jsp").forward(request, response);//转发，send开头为重定向
		else if(!user.getUserName().equals("wxy"))
			request.getRequestDispatcher("allbook.jsp").forward(request, response);//转发，send开头为重定向
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

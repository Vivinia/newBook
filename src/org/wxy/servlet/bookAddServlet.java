package org.wxy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wxy.dao.IBookDao;
import org.wxy.entity.Book;
import org.wxy.impl.BookDaoImpl;

public class bookAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public bookAddServlet() {
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
		request.getRequestDispatcher("utf-8");
		
		/*从表中取值*/
		String bName=request.getParameter("bName");
		String bAuthor=request.getParameter("bAuthor");
		String bPage=request.getParameter("bPage");
		String bPrice=request.getParameter("bPrice");
		
		/*创建对象并赋值*/
		Book book=new Book();
		book.setBookName(bName);
		book.setBookAuthor(bAuthor);
		book.setBookPage(Integer.parseInt(bPage));//String转换为int型
		book.setBookPrice(Double.parseDouble(bPrice));//String转换为double型
		
		/*执行添加操作*/
		IBookDao dao=new BookDaoImpl();
		dao.addBooks(book);
		
		/*重定向跳转*/
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

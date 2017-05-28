package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.wxy.dao.HibernateSessionFactory;
import org.wxy.dao.IBookDao;
import org.wxy.entity.Book;
import org.wxy.impl.BookDaoImpl;

public class updateBookServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateBookServlet() {
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
		
		/*表单中获取值*/
		String bId=request.getParameter("bId");
		String bName=request.getParameter("bName");
		String bAuthor=request.getParameter("bAuthor");
		String bPage=request.getParameter("bPage");
		String bPrice=request.getParameter("bPrice");
		
		/*创建对象并且赋值*/
		Book book=new Book();
		book.setBookId(Integer.parseInt(bId));
		book.setBookName(bName);
		book.setBookAuthor(bAuthor);
		book.setBookPage(Integer.parseInt(bPage));
		book.setBookPrice(Double.parseDouble(bPrice));
		
		/*执行更新操作*/
		IBookDao dao=new BookDaoImpl();
		dao.editBooks(book);
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

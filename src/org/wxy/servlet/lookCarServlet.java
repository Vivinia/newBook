package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wxy.dao.IBookDao;
import org.wxy.dao.ICarDao;
import org.wxy.entity.Book;
import org.wxy.entity.Car;
import org.wxy.entity.User;
import org.wxy.impl.BookDaoImpl;
import org.wxy.impl.CarDaoImpl;

public class lookCarServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public lookCarServlet() {
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
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");//获取存储的user信息
		//验证登录
		if(user==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);//转发，send开头为重定向
			return;
		}
		
		String id=user.getUserId().toString();
		ICarDao dao=new CarDaoImpl();
		List<Car> carList=dao.getCarsPageList(20,1,id);
		
		IBookDao bookdao=new BookDaoImpl();
		List<Book> bookList=new ArrayList<Book>();
		for(Car car:carList){
			String bookid=car.getBook().getBookId().toString();
			Book book=bookdao.getBooksItem(bookid);
			bookList.add(book);
		}
		HttpSession booksession=request.getSession();
		booksession.setAttribute("BookList",bookList);
		request.setAttribute("BookList",bookList);
		request.getRequestDispatcher("userCar.jsp").forward(request, response);
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

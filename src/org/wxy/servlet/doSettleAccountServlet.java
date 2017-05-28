package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wxy.dao.IConsignee;
import org.wxy.entity.Book;
import org.wxy.entity.Consignee;
import org.wxy.entity.User;
import org.wxy.impl.ConsigneeDaoImpl;

public class doSettleAccountServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doSettleAccountServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");

		HttpSession booksession = request.getSession();
		List<Book> bookList = (List<Book>) booksession.getAttribute("BookList");// 获取购物车中book信息
		double total = 0;
		int number = bookList.size();// 商品数量
		String name = "";
		for (Book book : bookList) {
			total += book.getBookPrice();// 计算总价
			name += book.getBookName() + ";";// 商品名称
		}
		request.setAttribute("total", total);
		request.setAttribute("number", number);
		request.setAttribute("name", name);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("uname", user.getUserName());
		String id = user.getUserId().toString();
		if (request.getSession().getAttribute("consigneeInfo") == null) {
			IConsignee dao = new ConsigneeDaoImpl();
			Consignee consignee = dao.getConsigneesItem(id);
			request.setAttribute("consigneeInfo", consignee);
		} else {
			Consignee consignee = (Consignee) request.getSession()
					.getAttribute("consigneeInfo");
			request.setAttribute("consigneeInfo", consignee);
		}
		request.getRequestDispatcher("submitOrder.jsp").forward(request,
				response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

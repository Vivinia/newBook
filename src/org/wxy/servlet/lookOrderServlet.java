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

import org.wxy.dao.IConsignee;
import org.wxy.dao.IOrderDao;
import org.wxy.entity.Consignee;
import org.wxy.entity.Order;
import org.wxy.entity.OrderShow;
import org.wxy.entity.User;
import org.wxy.impl.ConsigneeDaoImpl;
import org.wxy.impl.OrderDaoImpl;

public class lookOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public lookOrderServlet() {
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


		User user = (User) request.getSession().getAttribute("user");
		//验证登录
		if(user==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);//转发，send开头为重定向
			return;
		}
		IConsignee consigneedao = new ConsigneeDaoImpl();
		List<Consignee> consigneeList = consigneedao.getConsigneeByUserId(user
				.getUserId());// 根据用户获取用户收货集合

		List<OrderShow> orderShowtList=new ArrayList<OrderShow>();

		IOrderDao orderdao = new OrderDaoImpl();
		for (Consignee consignee : consigneeList) {
			List<Order> oList = orderdao.getOrdersPageList(20, 1, consignee
					.getConsigneeId().toString());// 获取每个收货地址的商品小集合
			for (Order o : oList) {
				OrderShow ord=new OrderShow(o.getOrderId(),o.getOrderTotal(),o.getOrderBook(),consignee.getConsigneeZipcode(),consignee.getConsigneePhone(),consignee.getConsigneeAddress());
				orderShowtList.add(ord);
			}
		}
		request.setAttribute("orderShowtList",orderShowtList);
		request.getRequestDispatcher("userOrder.jsp")
				.forward(request, response);
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

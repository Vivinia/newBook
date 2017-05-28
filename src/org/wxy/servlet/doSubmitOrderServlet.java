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
import org.wxy.dao.IOrderDao;
import org.wxy.entity.Book;
import org.wxy.entity.Consignee;
import org.wxy.entity.Order;
import org.wxy.entity.User;
import org.wxy.impl.BookDaoImpl;
import org.wxy.impl.CarDaoImpl;
import org.wxy.impl.OrderDaoImpl;

public class doSubmitOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doSubmitOrderServlet() {
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
		
		String bookName=request.getParameter("name");//商品名称
		String total=request.getParameter("total");//商品总价
		String consigneeId=request.getParameter("consigneeId");
		String consigneeZipcode=request.getParameter("consigneeZipcode");
		String consigneePhone=request.getParameter("consigneePhone");
		String consigneeAddress=request.getParameter("consigneeAddress");
		
		Consignee consignee=new Consignee();    //封装Consignee对象信息(收货信息)
		consignee.setConsigneeId(Integer.parseInt(consigneeId));
		consignee.setConsigneeZipcode(Integer.parseInt(consigneeZipcode));
		consignee.setConsigneePhone(consigneePhone);
		consignee.setConsigneeAddress(consigneeAddress);
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");//获取存储的user信息
		consignee.setUser(user);
		
		Order order=new Order();//封装order对象
		order.setOrderBook(bookName);
		System.out.println("bookName:"+bookName);
		order.setConsignee(consignee);
		order.setOrderTotal(Double.parseDouble(total));
		IOrderDao orderdao=new OrderDaoImpl();
		orderdao.addOrders(order);
		
		/*添加订单成功后要删除购物车信息*/
		ICarDao cardao=new CarDaoImpl();
		int iRow=cardao.delAllCars();
		if(iRow>0)
			request.getRequestDispatcher("bookListServlet").forward(request, response);
		else
			request.getRequestDispatcher("doSettleAccountServlet").forward(request, response);
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

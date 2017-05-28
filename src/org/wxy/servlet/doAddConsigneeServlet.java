package org.wxy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wxy.dao.IConsignee;
import org.wxy.entity.Consignee;
import org.wxy.entity.User;
import org.wxy.impl.ConsigneeDaoImpl;

public class doAddConsigneeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doAddConsigneeServlet() {
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
		
		String consigneeZipcode=request.getParameter("consigneeZipcode");
		String consigneePhone=request.getParameter("consigneePhone");
		String consigneeAddress=request.getParameter("consigneeAddress");
		
		Consignee consignee=new Consignee();
		consignee.setConsigneeZipcode(Integer.parseInt(consigneeZipcode));
		consignee.setConsigneePhone(consigneePhone);
		consignee.setConsigneeAddress(consigneeAddress);
		User user=(User) request.getSession().getAttribute("user");
		consignee.setUser(user);
		
		IConsignee dao=new ConsigneeDaoImpl();
		dao.addConsignees(consignee);
		request.getRequestDispatcher("doGetConsigneeServlet").forward(request, response);
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

package org.wxy.entity;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Consignee consignee;
	private Double orderTotal;
	private String orderBook;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Consignee consignee, Double orderTotal, String orderBook) {
		this.consignee = consignee;
		this.orderTotal = orderTotal;
		this.orderBook = orderBook;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Consignee getConsignee() {
		return this.consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Double getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderBook() {
		return this.orderBook;
	}

	public void setOrderBook(String orderBook) {
		this.orderBook = orderBook;
	}

}
package org.wxy.entity;

public class OrderShow {

	private Integer orderId;
	private Double orderTotal;
	private String orderBook;
	private Integer consigneeZipcode;
	private String consigneePhone;
	private String consigneeAddress;
	public OrderShow(Integer orderId, Double orderTotal, String orderBook,
			Integer consigneeZipcode, String consigneePhone,
			String consigneeAddress) {
		super();
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.orderBook = orderBook;
		this.consigneeZipcode = consigneeZipcode;
		this.consigneePhone = consigneePhone;
		this.consigneeAddress = consigneeAddress;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderBook() {
		return orderBook;
	}
	public void setOrderBook(String orderBook) {
		this.orderBook = orderBook;
	}
	public Integer getConsigneeZipcode() {
		return consigneeZipcode;
	}
	public void setConsigneeZipcode(Integer consigneeZipcode) {
		this.consigneeZipcode = consigneeZipcode;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

}

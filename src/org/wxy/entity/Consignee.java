package org.wxy.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Consignee entity. @author MyEclipse Persistence Tools
 */

public class Consignee implements java.io.Serializable {

	// Fields

	private Integer consigneeId;
	private User user;
	private Integer consigneeZipcode;
	private String consigneePhone;
	private String consigneeAddress;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Consignee() {
	}

	/** full constructor */
	public Consignee(User user, Integer consigneeZipcode,
			String consigneePhone, String consigneeAddress, Set orders) {
		this.user = user;
		this.consigneeZipcode = consigneeZipcode;
		this.consigneePhone = consigneePhone;
		this.consigneeAddress = consigneeAddress;
		this.orders = orders;
	}

	// Property accessors

	public Integer getConsigneeId() {
		return this.consigneeId;
	}

	public void setConsigneeId(Integer consigneeId) {
		this.consigneeId = consigneeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getConsigneeZipcode() {
		return this.consigneeZipcode;
	}

	public void setConsigneeZipcode(Integer consigneeZipcode) {
		this.consigneeZipcode = consigneeZipcode;
	}

	public String getConsigneePhone() {
		return this.consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeAddress() {
		return this.consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}
package org.wxy.entity;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private Integer carId;
	private Book book;
	private User user;
	private Integer carNumber;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** full constructor */
	public Car(Book book, User user, Integer carNumber) {
		this.book = book;
		this.user = user;
		this.carNumber = carNumber;
	}

	// Property accessors

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCarNumber() {
		return this.carNumber;
	}

	public void setCarNumber(Integer carNumber) {
		this.carNumber = carNumber;
	}

}
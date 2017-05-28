package org.wxy.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private Integer bookPage;
	private Double bookPrice;
	private Set collects = new HashSet(0);
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(String bookName, String bookAuthor, Integer bookPage,
			Double bookPrice, Set collects, Set cars) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPage = bookPage;
		this.bookPrice = bookPrice;
		this.collects = collects;
		this.cars = cars;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Integer getBookPage() {
		return this.bookPage;
	}

	public void setBookPage(Integer bookPage) {
		this.bookPage = bookPage;
	}

	public Double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Set getCollects() {
		return this.collects;
	}

	public void setCollects(Set collects) {
		this.collects = collects;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}
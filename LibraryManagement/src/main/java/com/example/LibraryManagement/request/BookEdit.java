package com.example.LibraryManagement.request;

import com.example.LibraryManagement.util.AvailableStatus;

public class BookEdit {
	private Long id;

	private String bookname;
	private float price;
	private String author;
	private AvailableStatus availableStatus;

	public AvailableStatus getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(AvailableStatus availableStatus) {
		this.availableStatus = availableStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

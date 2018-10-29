package com.example.LibraryManagement.response;

import com.example.LibraryManagement.util.AvailableStatus;

public class BookResponse {
	private Long id;
	private String bookname;
	private float price;
	private String authorname;
	private AvailableStatus availableStatus;
	private String studentname;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

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

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

}

package com.bookdetailsMicroService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books
{
	@Id
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String category;
	@Column
	private String author;
	@Column
	private String price;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookId) {
		super();
		this.bookId = bookId;
	}
	public Books(int bookId, String bookName, String category, String author, String price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.category = category;
		this.author = author;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", category=" + category + ", author=" + author
				+ ", price=" + price + "]";
	}	
}

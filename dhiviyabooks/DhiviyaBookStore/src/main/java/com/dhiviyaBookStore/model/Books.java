package com.dhiviyaBookStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Books
{
	@Id
	@NotNull(message = "cannot be null")
	private int bookId;
	@Column
	@NotNull(message = "cannot be null")
	@Size(min=3,message="min 3 characters")
	private String bookName;
	@Column
	@NotNull(message = "cannot be null")
	@Size(min=3,message="min 3 characters")
	private String category;
	@Column
	@NotNull(message = "cannot be null")
	@Size(min=3,message="min 3 characters")
	private String author;
	@Column
	@NotNull(message = "cannot be null")
	private float price;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookId) {
		super();
		this.bookId = bookId;
	}
	public Books(int bookId, String bookName, String category, String author, float price) {
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", category=" + category + ", author=" + author
				+ ", price=" + price + "]";
	}	
}

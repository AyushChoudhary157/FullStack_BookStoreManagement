package com.bookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a book in the user's personal "My Books" list.
 * This entity now has its own auto-incrementing primary key,
 * which is independent of the original Book's ID.
 */
@Entity
@Table(name="MyBooks")
public class MyBookList {

	// This is the new, auto-generated primary key for the MyBookList entity.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// This field stores the ID of the original book from the Book entity.
	@Column(name = "book_id")
	private int bookId;
	private String name;
	private String author;
	private String price;

	public MyBookList() {
		super();
	}

	// Corrected constructor: sets bookId, not id.
	public MyBookList(int bookId, String name, String author, String price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return String.valueOf(price);
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

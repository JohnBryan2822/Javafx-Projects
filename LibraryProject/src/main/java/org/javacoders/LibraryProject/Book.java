package org.javacoders.LibraryProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="library")
public class Book {
	
	@Id
	@Column(name="id")
	int id;
	@Column(name="title")
	String title;
	@Column(name="author")
	String author;
	@Column(name="publisher")
	String publisher;
	@Column(name="quantity")
	int quantity;
	
	public Book() {}

	public Book(int id, String title, String author, String publisher, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int isQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", availability=" + quantity + "]";
	}
}

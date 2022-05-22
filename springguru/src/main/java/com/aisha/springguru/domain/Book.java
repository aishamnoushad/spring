package com.aisha.springguru.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	private Long id;
	
	private String title;
	private String isbn;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="author_book" , joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id")
	)
	private Set<Author> authors = new HashSet<>();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	 public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String isbn, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (id!=null)?prime * result + (int) (id ^ (id >>> 32)):prime * result + (int) (158 ^ (0 >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
	}
	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	 

}

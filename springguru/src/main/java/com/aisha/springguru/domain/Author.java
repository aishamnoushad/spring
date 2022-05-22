package com.aisha.springguru.domain;

import java.util.Set;

public class Author {
	
	private String firstname;
	private String lastname;
	private Set<Book> books;
	
public Author() {
	// TODO Auto-generated constructor stub
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Set<Book> getBooks() {
	return books;
}

public void setBooks(Set<Book> books) {
	this.books = books;
}

}

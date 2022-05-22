package com.aisha.springguru.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	public Long id;
	
	private String firstname;
	private String lastname;
	@ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
	private Set<Book> books = new HashSet<>();
	
public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

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

public Author(String firstname, String lastname, Set<Book> books) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.books = books;
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
	result = (id!=null)?prime * result + (int) (id ^ (id >>> 32)):prime * result + (int) (158 ^ (123 >>> 32));
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
	Author other = (Author) obj;
	if (id != other.id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
}


}

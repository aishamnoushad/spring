package com.aisha.springguru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aisha.springguru.domain.Author;
import com.aisha.springguru.domain.Book;
import com.aisha.springguru.repositories.AuthorRepository;
import com.aisha.springguru.repositories.BookRepository;
@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}



	public BookRepository getBookRepository() {
		return bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book book = new Book("Domain Driven Development", "123123");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		authorRepository.save(eric);
		System.out.println(authorRepository.save(eric));
		bookRepository.save(book);
		System.out.println(bookRepository.save(book));
		Author john = new Author("John", "Thompsan");
		Book Springbook = new Book("Spring Guru", "123124");
		john.getBooks().add(Springbook);
		Springbook.getAuthors().add(john);
		authorRepository.save(john);
		bookRepository.save(Springbook);
		
		Author Elon = new Author("Elon", "Musk");
		Book twitter = new Book("Space Ex", "223124");
		Elon.getBooks().add(twitter);
		twitter.getAuthors().add(Elon);
		authorRepository.save(Elon);
		bookRepository.save(twitter);
		
		System.out.println("Started BootstrapData");
		System.out.println("The number of books = "+ bookRepository.count());
		System.out.println("The number of Authors = "+ authorRepository.count());
		
		
		

	}

}

package com.aisha.springguru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aisha.springguru.domain.Author;
import com.aisha.springguru.domain.Book;
import com.aisha.springguru.domain.Publisher;
import com.aisha.springguru.repositories.AuthorRepository;
import com.aisha.springguru.repositories.BookRepository;
import com.aisha.springguru.repositories.PublisherRepository;
@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository =publisherRepository;
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
		
		System.out.println(bookRepository.save(book));
		Author john = new Author("John", "Thompsan");
		Book Springbook = new Book("Spring Guru", "123124");
		john.getBooks().add(Springbook);
		Springbook.getAuthors().add(john);
		
		
		Author Elon = new Author("Elon", "Musk");
		Book twitter = new Book("Space Ex", "223124");
		Elon.getBooks().add(twitter);
		twitter.getAuthors().add(Elon);
		
		
		System.out.println("Started BootstrapData");
		System.out.println("The number of books = "+ bookRepository.count());
		System.out.println("The number of Authors = "+ authorRepository.count());
		Long zip = (long) 123567;
		
		Publisher sAndK = new Publisher("S And K Publication", "Office no 14", "Banglore city", "Banglore", "Karnataka", zip);
		
		zip = (long) 695467;
		Publisher dc = new Publisher("DC Publication", "Office no 14", "Trivandrum city", "Trivandrum", "kerala", zip);
		
		
		System.out.println("The number of Publishers = "+ publisherRepository.count());
		
		twitter.setPublisher(dc);
		book.setPublisher(dc);
		Springbook.setPublisher(sAndK);
		
		dc.getBooks().add(twitter);
		dc.getBooks().add(book);
		sAndK.getBooks().add(Springbook);
		
		authorRepository.save(eric);
		System.out.println(authorRepository.save(eric));
		bookRepository.save(book);
		
		authorRepository.save(john);
		bookRepository.save(Springbook);
		
		authorRepository.save(Elon);
		
		bookRepository.save(twitter);
		
		publisherRepository.save(dc);
		publisherRepository.save(sAndK);

	}

}

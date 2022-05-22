package com.aisha.springguru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aisha.springguru.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}

package com.aisha.springguru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aisha.springguru.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

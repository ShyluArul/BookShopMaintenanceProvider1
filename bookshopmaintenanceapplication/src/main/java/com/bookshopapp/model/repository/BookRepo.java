package com.bookshopapp.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshopapp.model.entities.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	
	 public Optional<Book> findBybookName(String bookName); 
	 // List<Book>findBybookNameContaining(String bookName);
	 public Optional<Book>findBookById(Long id);
}

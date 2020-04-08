package com.bookshopapp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookshopapp.model.entities.Book;

import com.bookshopapp.model.repository.BookRepo;

@SpringBootApplication
public class BookShopMaintenanceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(BookShopMaintenanceApplication.class, args);
	}

	@Autowired
	private BookRepo bookRepo;

	@Override
	public void run(String... args) throws Exception {
        /*
		 * Book b1 = new Book("Head First Java", 498, "Raj", 2005); 
		 * bookRepo.save(b1);
		 * Book b2= new Book("Spring", 333, "Mhetha", 2008);
		 *  bookRepo.save(b2);
		 */
    }
}

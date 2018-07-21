package com.sheila.book;

import com.sheila.book.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookInventoryApplication {

	private static final Logger log = LoggerFactory.getLogger(BookInventoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookInventoryApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(BookRepository bookRepository){
		return (args)->{
			bookRepository.save(new Book ("Midnight's Children", "Salman Rushdie", "Fiction"));
			bookRepository.save(new Book("How to Cook Everything Vegetarian ","Mark Bittman", "Cookbook"));
			bookRepository.save(new Book("White Teeth","Zadie Smith", "Fiction"));

			//fetch all
			log.info("Getting all books...");
			for(Book book: bookRepository.findAll()){
				log.info(book.toString());
			}
		};
	}
}

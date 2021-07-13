package com.maheshb.springbootdatajpaintro;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maheshb.springbootdatajpaintro.entities.BookEntity;
import com.maheshb.springbootdatajpaintro.repo.BookRepository;

@SpringBootApplication
public class SpringbootDataJpaIntroApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootDataJpaIntroApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaIntroApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			// save a few books
			bookRepository.save(new BookEntity("Spring Microservices in Action", "John Carnell", 2525.00));
			bookRepository
					.save(new BookEntity("Spring Microservices in Action, Second Edition", "John Carnell", 4700.00));
			bookRepository.save(new BookEntity("Learning Spring Boot 2.0", "Greg L. Turnquist", 2879.00));

			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			bookRepository.findAll().forEach(bookEntity -> log.info(bookEntity.toString()));
			log.info("");

			// fetch an individual customer by ID
			Optional<BookEntity> bookEntity = bookRepository.findById(1L);
			if (bookEntity.isPresent()) {
				log.info("Book found with findById(1L):");
				log.info("--------------------------------");
				log.info(bookEntity.get().toString());
				log.info("");
			}

			// fetch Books by author name
			log.info("Book found with findByAuthor('John Carnell'):");
			log.info("--------------------------------------------");
			bookRepository.findByAuthor("John Carnell").forEach(john -> {
				log.info(john.toString());
			});
			log.info("");

		};
	}
}

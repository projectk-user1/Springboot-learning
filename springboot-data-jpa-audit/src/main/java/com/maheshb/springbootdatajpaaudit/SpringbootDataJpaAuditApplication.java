package com.maheshb.springbootdatajpaaudit;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maheshb.springbootdatajpaaudit.entity.BookEntity;
import com.maheshb.springbootdatajpaaudit.repo.BookRepository;

@SpringBootApplication

public class SpringbootDataJpaAuditApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootDataJpaAuditApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaAuditApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			// save a few books
			log.info("Save 3 Books");
			log.info("-------------------------------");
			bookRepository.save(new BookEntity("Spring Microservices in Action", "John Carnell", 2525.00));
			bookRepository
					.save(new BookEntity("Spring Microservices in Action, Second Edition", "John Carnell", 4700.00));
			bookRepository.save(new BookEntity("Learning Spring Boot 2.0", "Greg L. Turnquist", 2879.00));

			// fetch all books
			log.info("Books found with findAll(): ");
			log.info("-------------------------------");

			Iterable<BookEntity> books = bookRepository.findAll();
			books.forEach(bookEntity -> log.info(bookEntity.toString()));

			log.info("Update Book() with id 1 ");
			log.info("-------------------------------");
			Optional<BookEntity> optionalBookEntity = bookRepository.findById(1L);
			if (optionalBookEntity.isPresent()) {
				BookEntity bookEntity = optionalBookEntity.get();
				bookEntity.setPrice(2524.00);
				bookEntity = bookRepository.save(bookEntity);
			}

			log.info("Fetch Updated Book ");
			log.info("-------------------------------");
			Optional<BookEntity> optionalBookEntity2 = bookRepository.findById(1L);
			if (optionalBookEntity.isPresent()) {
				log.info(optionalBookEntity2.get().toString());
			}
		};
	}
}

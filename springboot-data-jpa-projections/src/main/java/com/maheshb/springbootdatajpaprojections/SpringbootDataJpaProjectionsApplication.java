package com.maheshb.springbootdatajpaprojections;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.maheshb.springbootdatajpaprojections.dto.BookDTO;
import com.maheshb.springbootdatajpaprojections.dto.BookView;
import com.maheshb.springbootdatajpaprojections.dto.CustomBook;
import com.maheshb.springbootdatajpaprojections.entity.BookEntity;
import com.maheshb.springbootdatajpaprojections.repo.BookRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootDataJpaProjectionsApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootDataJpaProjectionsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaProjectionsApplication.class, args);
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

			// fetch all books
			log.info("Books found with findAllProjectedBy():");
			log.info("-------------------------------");
			bookRepository.findAllProjectedBy().forEach(bookView -> log.info("Book View {}, {}, {} ",
					bookView.getAuthor(), bookView.getName(), bookView.getPrice()));
			log.info("");

			// fetch Books by author name Entity Based
			log.info("Entity Based: Book found with findByAuthor('John Carnell'):");
			log.info("------------------------------------------");
			bookRepository.findByAuthor("John Carnell").forEach(bookEntity -> {
				log.info(bookEntity.toString());
			});

			// fetch Books by author name Class Based
			log.info("Class Based: Book found with findByAuthor('John Carnell'):");
			log.info("--------------------------------------------");
			bookRepository.findDTOByAuthor("John Carnell").forEach(book -> {
				log.info(book.toString());
			});

			// fetch Books by author name Interface Based
			log.info("Interface Based: Book found with findByAuthor('John Carnell'):");
			log.info("--------------------------------------------");
			List<BookView> books = bookRepository.findViewByAuthor("John Carnell");
			books.forEach(book -> {
				log.info("BookView {}, {}, {}", book.getName(), book.getAuthor(), book.getPrice());
			});

			// fetch an individual book by ID
			Optional<BookEntity> bookEntity = bookRepository.findById(1L);
			if (bookEntity.isPresent()) {
				log.info("Entity Based: Book found with findById(1L):");
				log.info("----------------------------------");
				log.info(bookEntity.get().toString());
				log.info("");
			}

			// fetch an individual book by ID
			Optional<BookDTO> bookDTO2 = bookRepository.findById(1L, BookDTO.class);
			if (bookDTO2.isPresent()) {
				log.info("Dynamic Projections ClassBased: Book found with findById(1L) BookDTO.class:");
				log.info("--------------------------------");
				log.info(bookDTO2.get().toString());
				log.info("");
			}

			Optional<BookView> bookView = bookRepository.findById(1L, BookView.class);
			if (bookView.isPresent()) {
				log.info("Dynamic Projections Interface Based: Book found with findById(1L) BookView.class:");
				log.info("--------------------------------");
				log.info("BookView {}, {}, {}", bookView.get().getName(), bookView.get().getAuthor(),
						bookView.get().getPrice());
				log.info("");
			}
			log.info("Map based Projections Books found with findAllWithMapResult");
			List<Map<String, Object>> results = bookRepository.findAllWithMapResult();
			List<CustomBook> list = results.stream().map(result -> new CustomBook(result)).collect(Collectors.toList());
			list.forEach(book -> {
				log.info(book.toString());
			});
			log.info("");
		};
	}
}
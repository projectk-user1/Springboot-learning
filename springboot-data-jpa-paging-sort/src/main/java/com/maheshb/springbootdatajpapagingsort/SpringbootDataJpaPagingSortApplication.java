package com.maheshb.springbootdatajpapagingsort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.maheshb.springbootdatajpapagingsort.entities.BookEntity;
import com.maheshb.springbootdatajpapagingsort.repo.BookRepository;

@SpringBootApplication
public class SpringbootDataJpaPagingSortApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootDataJpaPagingSortApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaPagingSortApplication.class, args);
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
			log.info("Books found with findAll(): Pagination");
			log.info("-------------------------------");
			Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
			Page<BookEntity> pages = bookRepository.findAll(firstPageWithTwoElements);

			List<BookEntity> books = pages.getContent();

			books.forEach(bookEntity -> log.info(bookEntity.toString()));
			log.info("Current Page {}", pages.getNumber());
			log.info("Total Items {}", pages.getTotalElements());
			log.info("Total Pages {}", pages.getTotalPages());
			log.info("");

			log.info("Books Sorted By name:");
			log.info("-------------------------------");
			Iterable<BookEntity> allBooksSortedByName = bookRepository.findAll(Sort.by("name"));
			allBooksSortedByName.forEach(bookEntity -> log.info(bookEntity.toString()));
			// order by 'author' column - ascending
			log.info("Books Sorted By author:");
			log.info("-------------------------------");
			Iterable<BookEntity> allBooksSortedByAuthor = bookRepository.findAll(Sort.by("author"));
			allBooksSortedByAuthor.forEach(bookEntity -> log.info(bookEntity.toString()));
			// order by 'author' column, descending
			log.info("Books Sorted By authoor descending:");
			log.info("-------------------------------");
			Iterable<BookEntity> allBooksSortedByPrice = bookRepository.findAll(Sort.by("author").descending());
			allBooksSortedByPrice.forEach(bookEntity -> log.info(bookEntity.toString()));
			// order by 'name' column - descending, then order by 'price' - ascending
			log.info("Books Sorted By name and price:");
			log.info("-------------------------------");
			Iterable<BookEntity> allBooksSortedByNameAndPrice = bookRepository
					.findAll(Sort.by("name").descending().and(Sort.by("price")));
			allBooksSortedByNameAndPrice.forEach(bookEntity -> log.info(bookEntity.toString()));

			/*Pageable sortedByName = PageRequest.of(0, 2, Sort.by("name"));
			Pageable sortedByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());
			Pageable sortedByPriceDescNameAsc = PageRequest.of(0, 5,
					Sort.by("price").descending().and(Sort.by("name")));*/
		};
	}
}

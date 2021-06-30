package com.maheshb.springbootcontentnegotiation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maheshb.springbootcontentnegotiation.dto.Book;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	/*
	 * HTTP Method standards 
	 * GET for retrieving,
	 * POST for creating,
	 * PUT for updating
	 * DELETE for deleting, 
	 * PATCH for partial updates
	 */

	/*
	 * Create a user: POST /books 
	 * Delete a user: DELETE /books/1 
	 * Get all users: GET /books 
	 * Get one user: GET /books/1
	 */
	
	/*
	 * Http Response status 
	 * 200 - Success 
	 * 404 - Resource Not Found 
	 * 400 - Bad Request (such as validation error) 
	 * 201 - Created 
	 * 401 - Unauthorized (when authorization fails) 
	 * 500 - Server Error
	 */
	Logger logger = LoggerFactory.getLogger(BooksController.class);

	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAll() {
		logger.info(">>>");
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "Spring Microservices in Action", "John Carnell", 2525.00));
		books.add(new Book(2, "Learning Spring Boot 2.0", "Greg L. Turnquist", 2879.00));
		return ResponseEntity.ok().body(books);
	}

	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		return ResponseEntity.ok().body(new Book(1, "Spring Microservices in Action", "John Carnell", 2525.00));
	}
}

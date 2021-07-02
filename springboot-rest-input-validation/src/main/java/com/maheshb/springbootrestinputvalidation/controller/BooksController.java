package com.maheshb.springbootrestinputvalidation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maheshb.springbootrestinputvalidation.dto.Book;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
	Logger logger = LoggerFactory.getLogger(BooksController.class);

	@PostMapping("/book")
	public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
		logger.info("Book: {} >>>", book);
		book.setId(UUID.randomUUID().toString());
		// Business Logic goes here
		logger.info("<<<");
		return ResponseEntity.ok().body(book);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}

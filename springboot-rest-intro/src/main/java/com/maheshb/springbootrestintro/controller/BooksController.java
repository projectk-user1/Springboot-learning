package com.maheshb.springbootrestintro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<String> books() {
		List<String> list = new ArrayList<>();
		list.add("Spring in Action");
		list.add("Pro Spring Boot 2");

		return list;
	}

}

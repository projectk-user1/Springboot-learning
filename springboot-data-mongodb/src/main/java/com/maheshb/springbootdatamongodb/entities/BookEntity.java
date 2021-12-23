package com.maheshb.springbootdatamongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "books")
public class BookEntity {

	@Id
	private String id;
	private String name;
	private String author;
	private Double price;

	public BookEntity(String id, String name, String author, Double price) {
		this.id = id;
		this.author = author;
		this.name = name;
		this.price = price;
	}
}

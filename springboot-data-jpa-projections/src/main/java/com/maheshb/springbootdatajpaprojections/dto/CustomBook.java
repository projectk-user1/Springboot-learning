package com.maheshb.springbootdatajpaprojections.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomBook implements Serializable {

	private static final long serialVersionUID = 6023997487227645594L;
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String AUTHOR = "author";
	public static final String PRICE = "price";

	private Long id;
	private String name;
	private String author;
	private Double price;

	public CustomBook(Map<String, Object> values) {
		this.id = values.get(ID) != null ? (Long) values.get(ID) : null;
		this.name = values.get(NAME) != null ? (String) values.get(NAME) : null;
		this.author = values.get(AUTHOR) != null ? (String) values.get(AUTHOR) : null;
		this.price = values.get(PRICE) != null ? (Double) values.get(PRICE) : null;
	}
}

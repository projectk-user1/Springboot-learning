package com.maheshb.springbootdatajpaprojections.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookDTO implements Serializable {
	private static final long serialVersionUID = -7392172999600013610L;
	private Long id;
	private String name;
	private String author;
	private Double price;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BookDTO bookDTO = (BookDTO) o;
		return Objects.equals(id, bookDTO.id) && Objects.equals(name, bookDTO.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	public BookDTO(Long id, String name, String author, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
}

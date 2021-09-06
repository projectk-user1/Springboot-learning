package com.maheshb.springbootdatajpaprojections.dto;

public interface BookView {

	String getName();

	String getAuthor();

	String getPrice();

//	@Value("#{target.name + ' ' + target.author}")
//	String getBookAndAuthorName();
}

package com.maheshb.springbootrestinputvalidation.dto;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Book {

	private String id;
	
	@NotBlank(message="Name must contain value")
	private String name;// The annotated element must not be null and must contain at least one
						// non-whitespace character.
	@NotEmpty(message="Publisher name must contain value")
	private String publisher; // The annotated element must not be null nor empty.

	@NotNull(message="Language must contain value")
	private String language; // The annotated element must not be null.

	@NotEmpty(message="Author Name must contain value")
	private String authorName;

	@Max(10000)
	@Min(0)
	private Integer noOfPapers; // The annotated element must be a strictly positive number

	@Digits(fraction = 0, integer = 10,message="ISBN must contain value")
	private long isbn; //

	@Positive(message="Weight In Gms must be a positive number")
	private Double weightInGms;

	@Size(min=0,max=3,message="Country Of Origin should be between 0 and 3 characters")
	private String countryOfOrigin;

	@DecimalMax(value = "1000000", inclusive = false)
	@DecimalMin(value = "0.1")
	private Double price;

	@Email(message="Author Email must be valid Email")
	private String authorEmail;
	
	@Pattern(regexp="(.+?)@(.+?)",message="Secondary Email must be valid Email")
	private String secondaryEmail;

	@PastOrPresent(message="Published Date must be in past")
	private Date publishedDate;

	@Size(min = 10, max = 256, message="Short Description should contain atleast 10 characters and maximum of 256 characters")
	private String shortDesc; // The annotated element size must be between the specified boundaries


	private String aboutAuthor;

	@PositiveOrZero(message="Customer Review must be non negative number")
	private Double custReview;

}

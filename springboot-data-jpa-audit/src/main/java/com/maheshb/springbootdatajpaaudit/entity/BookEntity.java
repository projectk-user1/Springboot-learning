package com.maheshb.springbootdatajpaaudit.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String author;
	private Double price;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	// Un comment below lines to save information in long.
/*	@CreatedDate
	private long createdDate;

	@LastModifiedDate
	private long modifiedDate;*/

	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String modifiedBy;

	public BookEntity(String name, String author, Double price) {
		this.author = author;
		this.name = name;
		this.price = price;
	}

}

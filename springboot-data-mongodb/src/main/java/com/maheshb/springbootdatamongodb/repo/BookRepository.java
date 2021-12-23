package com.maheshb.springbootdatamongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maheshb.springbootdatamongodb.entities.BookEntity;

public interface BookRepository extends MongoRepository<BookEntity, String> {

	public BookEntity findByName(String name);

	List<BookEntity> findByAuthor(String authorName);

	Optional<BookEntity> findById(String id);
}

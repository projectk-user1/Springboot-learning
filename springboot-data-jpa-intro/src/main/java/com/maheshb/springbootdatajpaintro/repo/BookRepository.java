package com.maheshb.springbootdatajpaintro.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maheshb.springbootdatajpaintro.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

	List<BookEntity> findByAuthor(String authorName);

	Optional<BookEntity> findById(Long id);
}

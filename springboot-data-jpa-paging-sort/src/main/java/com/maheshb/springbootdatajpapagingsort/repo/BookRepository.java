package com.maheshb.springbootdatajpapagingsort.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.maheshb.springbootdatajpapagingsort.entities.BookEntity;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long> {

	List<BookEntity> findByAuthor(String authorName, Pageable pageable);

}

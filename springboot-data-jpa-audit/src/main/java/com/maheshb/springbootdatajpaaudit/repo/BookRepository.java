package com.maheshb.springbootdatajpaaudit.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maheshb.springbootdatajpaaudit.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}

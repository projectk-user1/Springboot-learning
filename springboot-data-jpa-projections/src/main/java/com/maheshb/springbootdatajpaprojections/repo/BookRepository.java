package com.maheshb.springbootdatajpaprojections.repo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maheshb.springbootdatajpaprojections.dto.BookDTO;
import com.maheshb.springbootdatajpaprojections.dto.BookView;
import com.maheshb.springbootdatajpaprojections.dto.CustomBook;
import com.maheshb.springbootdatajpaprojections.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	List<BookEntity> findAll();

	List<BookEntity> findByAuthor(String name);

	// Interface based Projection
	List<BookView> findViewByAuthor(String name);

	List<BookView> findAllProjectedBy();

	// Class based Projection
	List<BookDTO> findByName(String name);

	List<BookDTO> findDTOByAuthor(String author);

	// Dynamic Projection
	<T> Optional<T> findById(Long id, Class<T> type);

	@Query("select b.id as " + CustomBook.ID + "," + " b.name as " + CustomBook.NAME + ", " + " b.author as "
			+ CustomBook.AUTHOR + ", b.price as " + CustomBook.PRICE + " from BookEntity b")
	List<Map<String, Object>> findAllWithMapResult();

}

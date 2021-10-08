package com.netsurfingzone.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netsurfingzone.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {

	// Solution using JPQL
	/*
	 * @Query("SELECT book FROM Book book LEFT JOIN FETCH book.storyList")
	 * public List<Book> findBooks();
	 */
}
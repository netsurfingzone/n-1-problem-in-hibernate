package com.netsurfingzone.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.netsurfingzone.entity.Book;

@Component
public interface BookService {
	public Book saveBook(Book book);

	public List<Book> findBooks();
}
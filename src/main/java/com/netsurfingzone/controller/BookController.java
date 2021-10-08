package com.netsurfingzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netsurfingzone.entity.Book;
import com.netsurfingzone.service.BookService;


@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = bookService.saveBook(book);
		return bookResponse;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getBookDetails() {
		List<Book> books= bookService.findBooks();

		return books;
	}

}
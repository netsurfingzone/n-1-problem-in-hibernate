package com.netsurfingzone.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsurfingzone.entity.Book;
import com.netsurfingzone.entity.Story;
import com.netsurfingzone.repository.BookRepository;
import com.netsurfingzone.service.BookService;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public Book saveBook(Book book) {

		List<Story> storyList = new ArrayList<>();

		// create first story
		Story story1 = new Story();
		story1.setStoryName("Push Ki Rat");

		// create second story
		Story story2 = new Story();
		story2.setStoryName("Idgah");

		// add all story into storyList. Till here we have prepared data for
		// OneToMany
		storyList.add(story1);
		storyList.add(story2);

		// Prepare data for ManyToOne
		story1.setBook(book);
		story2.setBook(book);

		book.setStoryList(storyList);
		book = bookRepository.save(book);

		return book;

	}

	@Transactional
	public List<Book> findBooks() {

		Session session = entityManager.unwrap(Session.class);
		// Below code will cause n+1 problem
		/*
		 * List<Book> books = session.createQuery("From Book",
		 * Book.class).getResultList(); return books;
		 */

		// HQL solution
		List<Book> books = session.createQuery("From Book book JOIN fetch book.storyList", Book.class).getResultList();
		return books;

		// return (List<Book>)bookRepository.findBooks();
	}

}
package com.spring.boot.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.application.dao.entity.MyBook;
import com.spring.boot.application.dao.jpa.repository.BookRepository;
import com.spring.boot.application.service.model.BookContext;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<MyBook> getAllMyBook() {

		return bookRepository.getAllMyBook();

	}

	public MyBook findBookById(Long bookId) {
		return bookRepository.findBookById(bookId);
	}

	@Transactional
	public Long save(BookContext bookContext) {// MyBook

		Long maxId = bookRepository.findMaxBookId() + 1;

		MyBook myBook = new MyBook();
		myBook.setBookId(maxId);
		myBook.setBookName(bookContext.getBookName());
		myBook.setAuthorName(bookContext.getAuthorName());
		myBook.setCategory(bookContext.getCategory());
		myBook.setPrice(bookContext.getPrice());
//		bookContext.setAuthorName("serdar");
//		bookContext.setBookName("dunya");
//		bookContext.setCategory("belgesel");
//		bookContext.setPrice(15L);
//		MyBook myBook=new MyBook();
//		myBook.setBookId(maxId);
//		myBook.setBookName(bookContext.getBookName());
//		myBook.setAuthorName(bookContext.getAuthorName());
//		myBook.setCategory(bookContext.getCategory());
//		myBook.setPrice(bookContext.getPrice());
		myBook = bookRepository.save(myBook);

		return myBook.getBookId();

	}

	public void save(MyBook myBook) {
		bookRepository.save(myBook);
	}
	public List<MyBook> findAllByOrderByBookNameAsc(){
		return bookRepository.findAllByOrderByBookNameAsc();
	}
	public void delete(Long bookId) {
		bookRepository.deleteById(bookId);
		 
	}
public List<MyBook> searchBy(String theName) {
		
		List<MyBook> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = bookRepository.findByBookNameContainsAllIgnoreCase(theName);
		}
		else {
			results = findAllByOrderByBookNameAsc();
		}
		
		return results;
	}

	
}

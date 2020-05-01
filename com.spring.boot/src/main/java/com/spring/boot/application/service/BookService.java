package com.spring.boot.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.application.dao.entity.MyBook;
import com.spring.boot.application.dao.jpa.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<MyBook> getAllMyBook(){
		
		return bookRepository.getAllMyBook();
		
	}
	
	public MyBook findBookById(Long bookId) {
		return bookRepository.findBookById(bookId);
	}

}

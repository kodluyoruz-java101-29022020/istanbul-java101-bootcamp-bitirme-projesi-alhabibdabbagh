package com.spring.boot.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.application.dao.entity.MyBook;
import com.spring.boot.application.service.BookService;
import com.spring.boot.application.service.model.BookContext;

@RestController
@RequestMapping("/application")
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/books/list",method=RequestMethod.GET)
	public List<MyBook> getAllMyBook(){
		return bookService.getAllMyBook();
	}
	@RequestMapping(value = "/book/{bookId}",method=RequestMethod.GET)
	public MyBook findBookById(@PathVariable ("bookId")Long bookId) {
		return bookService.findBookById(bookId);
	}
	@RequestMapping(value = "/book/save",method = RequestMethod.POST )
	public Long save (@RequestBody BookContext bookContext) {// MyBook
		return bookService.save(bookContext);
	}
	
}

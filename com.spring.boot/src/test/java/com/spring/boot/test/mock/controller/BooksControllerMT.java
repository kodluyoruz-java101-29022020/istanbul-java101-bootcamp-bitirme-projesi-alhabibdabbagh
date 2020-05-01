package com.spring.boot.test.mock.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.boot.application.controller.BooksController;
import com.spring.boot.application.dao.entity.MyBook;
import com.spring.boot.application.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BooksControllerMT {

	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BooksController booksController;
	
	
	@Before // burda kutuphane dikkat
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllMyBook() {
		
		MyBook myBook=new MyBook();
		myBook.setAuthorName("hasan korkmaz");
		myBook.setBookId(4L);
		myBook.setCategory("funny1");
		
		MyBook myBook1=new MyBook();
		myBook1.setAuthorName("aysa korkmaz");
		myBook1.setBookId(5L);
		myBook1.setCategory("funny2");
		
		List<MyBook> booksList1=Arrays.asList(myBook,myBook1);
		
	Mockito
	.when( bookService.getAllMyBook())
	.thenReturn(booksList1);
		
	List<MyBook> booksList=booksController.getAllMyBook();
	
	Assert.assertNotNull(booksList);
		
	}
	
	
	
}

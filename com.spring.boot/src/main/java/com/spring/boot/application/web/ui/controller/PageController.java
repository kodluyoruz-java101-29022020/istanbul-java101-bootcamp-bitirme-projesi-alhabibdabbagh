package com.spring.boot.application.web.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.application.dao.entity.MyBook;
import com.spring.boot.application.service.BookService;
import com.spring.boot.application.service.model.BookContext;

@Controller
@RequestMapping("/web")
public class PageController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getAllMyBooks(Model model) {
		List<MyBook> books = bookService.getAllMyBook();
		model.addAttribute("books", books);

		return "books/thymeleaf_Book_listem";
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {

		return "thymeleaf_Book_save";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String save(Model model, BindingResult resualt, BookContext bookContext) {

		bookService.save(bookContext);

		model.addAttribute("books", bookService.getAllMyBook());

		return "thymeleaf_Book_list";
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model, BookContext bookContext) {
		MyBook myBook = new MyBook();
		model.addAttribute("books", myBook);

		return "books/book-form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") Long bookId, Model model) {

		// get the book from service
		MyBook myBook = bookService.findBookById(bookId);

		// set books
		model.addAttribute("books", myBook);

		return "books/book-form.html";
	}

	@PostMapping("/save")
	public String savaBook(@ModelAttribute("books") MyBook myBook) {

		bookService.save(myBook);
		return "redirect:/web/book/list";
	}

}

package com.library.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.request.BookCreation;
import com.library.book.request.BookEdit;
import com.library.book.response.BookResponse;
import com.library.book.services.BookService;

@RestController
@RequestMapping("rest/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createBook(@RequestBody BookCreation bookCreation) {
		bookService.createBook(bookCreation);
		return new ResponseEntity<>("DONE", HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getBook(@RequestHeader String bookname) {
		BookResponse br = bookService.getBook(bookname);
		return new ResponseEntity<>(br, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> editBook(@RequestBody BookEdit bookEdit) {
		bookService.editBook(bookEdit);
		return new ResponseEntity<>("DONE", HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteBook(@RequestHeader Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>("DELETED", HttpStatus.OK);
	}

	@RequestMapping(value = "getall", method = RequestMethod.GET)

	public ResponseEntity<Object> getallBook() {
		List<BookResponse> br = bookService.getallBook();
		return new ResponseEntity<>(br, HttpStatus.ACCEPTED);
	}
	

	
}

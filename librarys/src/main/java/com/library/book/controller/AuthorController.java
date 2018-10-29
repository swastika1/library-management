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


import com.library.book.request.AuthorCreation;
import com.library.book.response.AuthorResponse;
import com.library.book.services.AuthorService;

@RestController
@RequestMapping("rest/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createAuthor(@RequestBody AuthorCreation authorCreation ){
		authorService.createAuthor(authorCreation);
		return new ResponseEntity<>("craeted",HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAuthor(@RequestHeader Long id) {
		AuthorResponse ar = authorService.getAuthor(id);
		return new ResponseEntity<>(ar, HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAuthor(@RequestHeader Long id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity<>("DELETED", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public ResponseEntity<Object> getallAuthor() {
		List<AuthorResponse> ar = authorService.getallAuthor();
		return new ResponseEntity<>(ar, HttpStatus.ACCEPTED);

	}


}

package com.library.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.request.UserRequest;
import com.library.book.services.UserService;

@RestController
@RequestMapping("rest/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody UserRequest requestCreationRequest/*,@RequestHeader String authorization*/){
		userService.registerUser(requestCreationRequest);
		return new ResponseEntity<>("user Created Successfully",HttpStatus.CREATED);
	}

}

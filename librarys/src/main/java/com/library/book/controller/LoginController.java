package com.library.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.request.LoginRequest;
import com.library.book.services.LoginService;


@RestController
@RequestMapping("rest/logins")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ResponseEntity<Object> login(LoginRequest request)//,@RequestHeader String authorization)
			{
		loginService.doLogin(request);
		return new ResponseEntity<Object>("Successfully loggedin",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public ResponseEntity<Object> logOut(@RequestHeader Long loginId /*@RequestHeader String authorization*/){
		loginService.doLogOut(loginId);
		return new ResponseEntity<Object>("Successfully loggedOut",HttpStatus.OK);
		
	}

}

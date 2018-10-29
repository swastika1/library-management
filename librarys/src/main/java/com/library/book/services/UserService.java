package com.library.book.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.exception.AlreadyExistException;
import com.library.book.exception.NotFoundException;
import com.library.book.model.Login;
import com.library.book.model.User;
import com.library.book.repositary.LoginRepository;
import com.library.book.repositary.UserRepository;
import com.library.book.request.UserRequest;
import com.library.book.util.LoginStatus;
import com.library.book.util.Status;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	

	@Transactional
	public void registerUser(UserRequest request) {
		
		User u=userRepository.findByEmailAndStatus(request.getEmail(),Status.ACTIVE);
		if(u!=null) {
			throw new NotFoundException("user with email "+request.getEmail()+" already found.");
		}
		
		Login logins=loginRepository.findByUsernameAndStatusNot(request.getUsername(),Status.DELETED);
		if(logins!=null)
			throw new AlreadyExistException("Username already exists.");
		
		User user=new User();
		user.setAddress(request.getAddress());
		user.setUserRole(request.getUserStatus());
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPhoneNo(request.getPhoneNo());
		user.setStatus(Status.ACTIVE);
		userRepository.save(user);	
		
		
		Login login=new Login();
		login.setUsername(request.getUsername());
		login.setPassword(request.getPassword());
		login.setStatus(Status.ACTIVE);
		login.setLoginStatus(LoginStatus.LOGGEDOUT);
		loginRepository.save(login);
		
	}
	
	
	

}

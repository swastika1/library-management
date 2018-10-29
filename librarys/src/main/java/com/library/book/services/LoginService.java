package com.library.book.services;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.model.Login;
import com.library.book.repositary.LoginRepository;
import com.library.book.request.LoginRequest;
import com.library.book.util.LoginStatus;
import com.library.book.util.Status;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Transactional
	public void doLogin(LoginRequest request) {
		Login login = loginRepository.findByUsernameAndStatusNot(request.getUsername(), Status.DELETED);
		if (login != null) {
			if (login.getPassword().equals(request.getPassword()))
				System.out.println("Successfully LoggedIn");
			else {
				throw new ServiceException("Password mismatch!");
			}
		} else {
			throw new ServiceException("Username not FOund!");
		}
		login.setLoginStatus(LoginStatus.LOGGEDIN);
		loginRepository.save(login);

	}

	@Transactional
	public void doLogOut(Long loginId) {
		Login login = loginRepository.findByIdAndStatusNot(loginId, Status.DELETED);
		if (login == null){
			throw new ServiceException("user with loginId " + loginId + " not found");
		}
		else{
		login.setLoginStatus(LoginStatus.LOGGEDOUT);
		loginRepository.save(login);
		}
	}

}

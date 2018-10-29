package com.library.book.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.book.model.Login;
import com.library.book.util.Status;

@Repository
public interface LoginRepository extends JpaRepository <Login, Long>{
	Login findByUsernameAndStatusNot(String username, Status deleted);

	Login findByIdAndStatusNot(Long loginId, Status deleted);


}

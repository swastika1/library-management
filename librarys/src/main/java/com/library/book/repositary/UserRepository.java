package com.library.book.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.book.model.User;
import com.library.book.util.Status;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

	User findByEmailAndStatus(String email, Status active);

}

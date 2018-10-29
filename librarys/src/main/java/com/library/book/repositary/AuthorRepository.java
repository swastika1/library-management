package com.library.book.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.book.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
	
	Author findByAuthorName(String authorName);

}

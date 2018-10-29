package com.example.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByAuthorname(String author);

}

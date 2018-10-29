package com.library.book.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.book.model.Book;
@Repository
public interface BookRepositary extends JpaRepository<Book,Long>  {

	Book findByBookname(String bookname);
}

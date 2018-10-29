package com.library.book.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;



import org.springframework.stereotype.Service;


import com.library.book.model.Author;
import com.library.book.model.Book;
import com.library.book.repositary.AuthorRepository;
import com.library.book.repositary.BookRepositary;
import com.library.book.request.BookCreation;
import com.library.book.request.BookEdit;
import com.library.book.response.BookResponse;


@Service
public class BookService {
	
	
	@Autowired
	private BookRepositary bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional
	public void createBook(BookCreation bookCreation) {
		Book boo = bookRepository.findByBookname(bookCreation.getBookname());
		if (boo == null) {
			Book book = new Book();
			
			book.setBookname(bookCreation.getBookname());
			book.setPrice(bookCreation.getPrice());
		    
		  
		    Author author = authorRepository.findByAuthorName(bookCreation.getAuthorName());
		    
		    book.setAuthor(author);
		   

		    bookRepository.save(book);
		    
		} else {

			boo.setQuantity(bookCreation.getQuantity() + 1);

		}
	}

	@Transactional
	public BookResponse getBook(String bookname) {
		Book book = bookRepository.findByBookname(bookname);
		if (book == null) {
			throw new ServiceException("BOOK " + bookname + " NOT FOUND");
		}
		BookResponse br = new BookResponse();
		br.setId(book.getId());
		br.setBookname(book.getBookname());
		br.setPrice(book.getPrice());
		br.setQuantity(book.getQuantity()); 
	    
		
		Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		br.setAuthorname(author.get().getAuthorName());
		

		return br;

	}

	@Transactional
	public void editBook(BookEdit bookEdit) {
		Optional<Book> book = bookRepository.findById(bookEdit.getId());
		if (!book.isPresent()) {
			throw new ServiceException("ID " + bookEdit.getId() + " NOTFOUND");

		}

		
		book.get().setBookname(bookEdit.getBookname());
		book.get().setPrice(bookEdit.getPrice());
		
		bookRepository.save(book.get());

	}

	@Transactional
	public void deleteBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (!book.isPresent()) {
			throw new ServiceException("ID " + id + " NOTFOUND");

		}
		bookRepository.delete(book.get());
	}

	@Transactional
	public List<BookResponse> getallBook() {
		List<Book> book = bookRepository.findAll();
		if (book.isEmpty()) {
			throw new ServiceException("EMPTY");
		}
		List<BookResponse> brList = new ArrayList<>();
		book.stream().forEach(u -> {
			BookResponse br = new BookResponse();
			br.setId(u.getId());
			br.setBookname(u.getBookname());
			br.setPrice(u.getPrice());
			
		    Optional<Author> author= authorRepository.findById(u.getAuthor().getId());
		    br.setAuthorname(author.get().getAuthorName());
			brList.add(br);
		});
		return brList;
	}
	

}

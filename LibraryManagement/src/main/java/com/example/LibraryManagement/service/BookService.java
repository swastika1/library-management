package com.example.LibraryManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagement.model.Author;
import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.Student;
import com.example.LibraryManagement.repository.AuthorRepository;
import com.example.LibraryManagement.repository.BookRepository;
import com.example.LibraryManagement.repository.StudentRepository;
import com.example.LibraryManagement.request.BookCreation;
import com.example.LibraryManagement.request.BookEdit;
import com.example.LibraryManagement.response.BookResponse;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void createBook(BookCreation bookCreation) {
		Book boo = bookRepository.findByBookname(bookCreation.getBookname());
		if (boo == null) {
			Book book = new Book();
			book.setBookname(bookCreation.getBookname());
			book.setPrice(bookCreation.getPrice());
			book.setAvailableStatus(bookCreation.getAvailableStatus());
			book.setQuantity(bookCreation.getQuantity());
			Author author = authorRepository.findByAuthorname(bookCreation.getAuthorname());
			book.setAuthor(author);
			Student student = studentRepository.findByStudentname(bookCreation.getStudentname());
			book.setStudent(student);
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
		br.setAvailableStatus(book.getAvailableStatus());
		Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		br.setAuthorname(author.get().getAuthorname());
		Optional<Student> student = studentRepository.findById(book.getStudent().getId());
		br.setStudentname(student.get().getStudentname());
		br.setQuantity(book.getQuantity());

		return br;

	}

	@Transactional
	public void editBook(BookEdit bookEdit) {
		Optional<Book> book = bookRepository.findById(bookEdit.getId());
		if (!book.isPresent()) {
			throw new ServiceException("ID " + bookEdit.getId() + " NOTFOUND");

		}
		book.get().setAvailableStatus(bookEdit.getAvailableStatus());
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
			Optional<Author> author = authorRepository.findById(u.getAuthor().getId());
			br.setAuthorname(author.get().getAuthorname());
			Optional<Student> student = studentRepository.findById(u.getStudent().getId());
			br.setStudentname(student.get().getStudentname());
			brList.add(br);
		});
		return brList;
	}

}

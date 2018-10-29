package com.example.LibraryManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagement.model.Author;
import com.example.LibraryManagement.repository.AuthorRepository;
import com.example.LibraryManagement.request.AuthorCreation;
import com.example.LibraryManagement.response.AuthorResponse;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Transactional
	public void createAuthor(AuthorCreation authorCreation) {
		Author auth = authorRepository.findByAuthorname(authorCreation.getAuthorname());
		if (auth == null) {

			Author author = new Author();
			author.setAuthorname(authorCreation.getAuthorname());
			author.setAddress(authorCreation.getAddress());
			authorRepository.save(author);
		} else {
			throw new ServiceException("ALREADY EXIST");
		}

	}

	@Transactional
	public AuthorResponse getAuthor(Long id) {
		Optional<Author> author = authorRepository.findById(id);
		if (!author.isPresent()) {
			throw new ServiceException("ID " + id + " NOT FOUND");
		}
		AuthorResponse ar = new AuthorResponse();
		ar.setId(author.get().getId());
		ar.setAuthorname(author.get().getAuthorname());
		ar.setAddress(author.get().getAddress());
		return ar;
	}

	@Transactional
	public void deleteAuthor(Long id) {
		Optional<Author> author = authorRepository.findById(id);
		if (!author.isPresent()) {
			throw new ServiceException("ID " + id + " NOT FOUND");

		}
		authorRepository.delete(author.get());

	}

	@Transactional
	public List<AuthorResponse> getallAuthor() {
		List<Author> author = authorRepository.findAll();
		if (author.isEmpty()) {
			throw new ServiceException("NOT FOUND");
		}
		List<AuthorResponse> arList = new ArrayList<>();
		author.stream().forEach(u -> {
			AuthorResponse ar = new AuthorResponse();
			ar.setId(u.getId());
			ar.setAuthorname(u.getAuthorname());
			ar.setAddress(u.getAddress());
			arList.add(ar);
		});
		return arList;
	}

}

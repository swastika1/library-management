package com.library.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.model.Author;
import com.library.book.repositary.AuthorRepository;
import com.library.book.request.AuthorCreation;
import com.library.book.response.AuthorResponse;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional
	public void createAuthor(AuthorCreation authorCreation){
		
		Author auth= authorRepository.findByAuthorName(authorCreation.getAuthorName());
		
		if(auth== null){
			Author author=new Author();
			author.setAuthorName(authorCreation.getAuthorName());
			author.setAddress(authorCreation.getAddress());
			
			authorRepository.save(author);
			
		}
		else{
			throw new ServiceException("Already Exist");
		}
		
	}
	
	@Transactional
	public AuthorResponse getAuthor(Long id){
		
		Optional<Author> author= authorRepository.findById(id);
		
		if(!author.isPresent()){
			throw new ServiceException("id" +id +"not found");
			
			
		}
		
		AuthorResponse ar= new AuthorResponse();
		
		ar.setId(author.get().getId());
		ar.setAuthorName(author.get().getAuthorName());
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
			ar.setAuthorName(u.getAuthorName());
			ar.setAddress(u.getAddress());
			arList.add(ar);
		});
		return arList;
	}

	
	

}

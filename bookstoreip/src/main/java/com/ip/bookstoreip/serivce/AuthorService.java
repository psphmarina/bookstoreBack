package com.ip.bookstoreip.serivce;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.bookstoreip.entity.Author;
import com.ip.bookstoreip.repository.AuthorRepository;
@Service
public class AuthorService {
	@Autowired
    private final AuthorRepository authorRepository;
 
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
 
    public void createAuthor(Author author){
        authorRepository.save(author);
    }
    public List<Author> findAllById(Integer id){
        return authorRepository.findAllById(id);
    }
}

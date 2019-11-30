package com.ip.bookstoreip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ip.bookstoreip.entity.Author;
import com.ip.bookstoreip.entity.Book;
import com.ip.bookstoreip.repository.AuthorRepository;
@CrossOrigin
@RestController
public class AuthorController {
	@Autowired
	   AuthorRepository authorRepository;
	// Получить все записи
	   @GetMapping("/authors")
	   public List getAllNotes() {
	       return authorRepository.findAll();
	   }
	// Создать запись
	   @PostMapping("/authors")
	   public Author createNote(@Valid @RequestBody Author author) {
	       return authorRepository.save(author);
	   }
	// Получить запись по id
	   @GetMapping("/authors/{id}")
	   public Author getNoteById(@PathVariable(value = "id") Integer id) throws Exception {
	       return authorRepository.findById(id)
	               .orElseThrow(() -> new Exception());
	   }
	// Обновить запись
	   @PutMapping("/authors/upd/{id}")
	   public Author updateNote(@PathVariable(value = "id") Integer id,
	                          @Valid @RequestBody Author authorDetails) throws Exception {
	       
	       Author author = authorRepository.findById(id)
	               .orElseThrow(() -> new Exception());
	       
	       author.setName(authorDetails.getName());
	       author.setSurname(authorDetails.getSurname());
	       author.setPatronymic(authorDetails.getPatronymic());
	       
	       Author updatedAuthor = authorRepository.save(author);
	       return updatedAuthor;
	   } 
	// Удалить запись по id
	   @DeleteMapping("/authors/{id}")
	   public void deleteAuthor(@PathVariable(value = "id") Integer id) throws Exception {
	       Author author = authorRepository.findById(id)
	               .orElseThrow(() -> new Exception());
	       
	       authorRepository.delete(author);
	       //return ResponseEntity.ok().build();
	   }
}

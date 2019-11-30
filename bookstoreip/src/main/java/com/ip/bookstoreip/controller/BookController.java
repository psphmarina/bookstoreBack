package com.ip.bookstoreip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ip.bookstoreip.entity.Book;
import com.ip.bookstoreip.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	   BookRepository bookRepository;
	// Получить все записи
	   @GetMapping("/books")
	   public List getAllNotes() {
	       return bookRepository.findAll();
	   }
	// Создать запись
	   @PostMapping("/books")
	   public Book createNote(@Valid @RequestBody Book book) {
	       return bookRepository.save(book);
	   }
	// Получить запись по id
	   @GetMapping("/books/{id}")
	   public Book getNoteById(@PathVariable(value = "id") Integer bookId) throws Exception {
	       return bookRepository.findById(bookId)
	               .orElseThrow(() -> new Exception());
	   }
	// Обновить запись
	   @PutMapping("/books/{id}")
	   public Book updateNote(@PathVariable(value = "id") Integer bookId,
	                          @Valid @RequestBody Book bookDetails) throws Exception {
	       
	       Book book = bookRepository.findById(bookId)
	               .orElseThrow(() -> new Exception());
	       
	       book.setName(bookDetails.getName());
	       book.setPrice(bookDetails.getPrice());
	       book.setAuthor(bookDetails.getAuthor());
	       
	       Book updatedBook = bookRepository.save(book);
	       return updatedBook;
	   }
	// Удалить запись по id
	   @DeleteMapping("/books/{id}")
	   public ResponseEntity deleteBook(@PathVariable(value = "id") Integer bookId) throws Exception {
	       Book book = bookRepository.findById(bookId)
	               .orElseThrow(() -> new Exception());
	       
	       bookRepository.delete(book);
	       return ResponseEntity.ok().build();
	   }
}

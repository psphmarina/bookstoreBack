package com.ip.bookstoreip.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.bookstoreip.entity.Book;
import com.ip.bookstoreip.repository.BookRepository;
@Service
public class BookService {
	@Autowired
    private final BookRepository bookRepository;
 
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
 
    public void createBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> findAllByName(String name){
        return bookRepository.findAllByName(name);
    }
}

package com.ip.bookstoreip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ip.bookstoreip.entity.Author;
import com.ip.bookstoreip.entity.Book;
import com.ip.bookstoreip.serivce.AuthorService;
import com.ip.bookstoreip.serivce.BookService;

@SpringBootApplication
public class BookstoreipApplication {
	 @Autowired
	 private BookService bookService;
	 @Autowired
	 private AuthorService authorService;
	public static void main(String[] args) {
		SpringApplication.run(BookstoreipApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	   private void testJpaMethods(){
	 
	      //bookService.findAllByName("Мертвая зона").forEach(it-> System.out.println(it));
	      //authorService.findAllByName("Дэниэл").forEach(it-> System.out.println(it));
	   }
}

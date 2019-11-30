package com.ip.bookstoreip.repository;
import com.ip.bookstoreip.entity.Book;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findAllByName(String name);
}

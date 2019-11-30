package com.ip.bookstoreip.repository;
import com.ip.bookstoreip.entity.Author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	List<Author> findAllById(Integer author_id);
}

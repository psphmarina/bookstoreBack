package com.ip.bookstoreip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ip.bookstoreip.entity.Author;
import com.ip.bookstoreip.entity.Files;

public interface FileRepository extends JpaRepository<Files, Integer>{
	List<Files> findAllById(Integer _id);
}

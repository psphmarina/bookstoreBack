package com.ip.bookstoreip.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.bookstoreip.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findAllById(Integer user_id);
	List<User> findAllByUsername(String username); 
	@Query("select u from User u where u.username = :username and u.password = :password" )//если этого мало можно написать
    //собственный запрос на языке похожем на SQL
	List <User> findAllByParameters(@Param("username") String username, @Param("password") String password);

	
	@Query("select u from User u where u.token = :token" )//если этого мало можно написать
    //собственный запрос на языке похожем на SQL
	List <User> findUserByToken(@Param("token") String token);
}

package com.ip.bookstoreip.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.ip.bookstoreip.entity.User;
import com.ip.bookstoreip.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 
import com.ip.bookstoreip.security.config.UserSecurity;
import com.ip.bookstoreip.serivce.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
    UserService userService;

    private UserSecurity userSecurity;
    
	@Autowired
	   UserRepository userRepository;
    
    @PostMapping("/registration")
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        user.setAdmin(false);
    }
    
    @PostMapping("/auth")
    public ResponseEntity validateUser(@Valid @RequestBody User user) {
        List <User> users = userService.findAllByParameters(user);
        if(users.size() == 0) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("неверно");
        }
        else {
            user = users.get(0);
        	userSecurity = new UserSecurity();
        	final String token = userSecurity.generateToken(user.getUsername(), user.getPassword());
        	user.setToken(token);
        	userRepository.save(user);
        	return ResponseEntity.ok(user);
        }
    }
}

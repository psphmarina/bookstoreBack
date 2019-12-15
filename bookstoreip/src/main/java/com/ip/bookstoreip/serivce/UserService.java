package com.ip.bookstoreip.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.ip.bookstoreip.entity.User;
import com.ip.bookstoreip.repository.UserRepository; 
@Service
public class UserService  {
	@Autowired
    private final UserRepository userRepository;
	
	 public UserService(UserRepository userRepository){
	        this.userRepository = userRepository;
	    }
	
	public void createUser(User user){
        userRepository.save(user);
    }
	
	public List<User> findAllByParameters(User user){
        return userRepository.findAllByParameters(user.getUsername(), user.getPassword());
    }
	public List<User> findAll(User user){
        return userRepository.findAll();
    }
	public boolean isAdmin(String token){
		if (token == null || token == "") {
			return false;
		}
		List<User> users = userRepository.findUserByToken(token);
		if (users.size() == 0) {
			return false;
		}
		User user = users.get(0);
		boolean res = user.getAdmin();
		return res;
	}
	
	public boolean isAuth(String token){
		if (token == null || token == "") {
			return false;
		}
		List<User> yusers = userRepository.findUserByToken(token);
		if (yusers.size() == 0) {
			return false;
		}
		return true;
	}
}
package com.ip.bookstoreip.security.config;

public class UserSecurity {
	//final static String forToken = "qwertyu";
	
		public String generateToken(String username, String password) {
			int random_number = (int) (1000000 + (Math.random() * 9999999));
			String forToken = String.valueOf(random_number);		
			return username + forToken + password;
		}
}

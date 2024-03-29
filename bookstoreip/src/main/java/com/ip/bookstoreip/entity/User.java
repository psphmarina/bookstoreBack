package com.ip.bookstoreip.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
  

import java.util.Collection;
@Entity
@Table(name = "myuser")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
	@Column
    private String username;
	@Column
    private String password;
	@Column
    private Boolean admin;
	 public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    @Column
    private String token;
    public void setToken(String token) {
        this.token = token;
    }
	public String getToken() {
		return token;
}
    
}

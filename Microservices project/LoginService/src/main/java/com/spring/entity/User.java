package com.spring.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String username;
     
    @Column(nullable = false, length = 64)
    private String password;
    
    private boolean loggedIn;
     
    
    public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
    
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
		this.loggedIn = loggedIn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return username;
	}

	public void setEmail(String email) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", loggedIn=" + loggedIn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, id, loggedIn, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username) && id == other.id && loggedIn == other.loggedIn
				&& Objects.equals(password, other.password);
	}

	

	

	    
    
    
}
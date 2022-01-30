package com.securityTwoStep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secret_key")
public class UserSecretKey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String key;
	public UserSecretKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "UserSecretKey [id=" + id + ", username=" + username + ", key=" + key + "]";
	}
	
	
}

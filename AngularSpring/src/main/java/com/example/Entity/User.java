package com.example.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
     
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
    @Id
    @GenericGenerator(name = "customId", strategy = "com.example.generator.ClientIdGenerator")
    @GeneratedValue(generator = "customId")
    private long id;
    private String name;
    private String email;
    
    public User() {
    	name = "Arsalan";
    	email = "abc@gmail.com";
    };
    
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}

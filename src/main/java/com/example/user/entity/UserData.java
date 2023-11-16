package com.example.user.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Entity

public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String name;
	private String uniqueId;
	private String emailId;
	private UUID productId = UUID.randomUUID();
	
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(String name, String uniqueId, String emailId) {
		super();
		this.name = name;
		this.uniqueId = uniqueId;
		this.emailId = emailId;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	
	
	

}

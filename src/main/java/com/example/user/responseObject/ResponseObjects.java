package com.example.user.responseObject;

import com.example.user.entity.UserData;
import com.example.user.productMapping.Products;

public class ResponseObjects {
	private UserData userData;
	private Products products;
	
	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	

}

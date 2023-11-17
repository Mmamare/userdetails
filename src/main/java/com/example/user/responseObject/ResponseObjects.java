package com.example.user.responseObject;

import com.example.user.entity.UserData;
import com.example.user.product_and_address_Mapping.Address;
import com.example.user.product_and_address_Mapping.Products;

public class ResponseObjects {
	private UserData userData;
	private Products products;
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
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

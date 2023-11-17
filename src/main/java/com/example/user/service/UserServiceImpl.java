package com.example.user.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.entity.UserData;
import com.example.user.product_and_address_Mapping.Address;
import com.example.user.product_and_address_Mapping.Products;
import com.example.user.repo.UserRepo;
import com.example.user.responseObject.ResponseObjects;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserData saveUserToDb(UserData userData) {
		return userRepo.save(userData);
	}

	@Override
	public UserData getUserByUnique(String uniqueId) {
		return userRepo.findUserByUniqueId(uniqueId);
	}

	@Override
	public void deleteById(Long id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public List<UserData> fetchuserData() {
		return (List<UserData>) userRepo.findAll();
	}

	@Override
	public UserData updateUserData(UserData userData, Long id) {
		UserData userDb =  (UserData) userRepo.findById(id).get();
		
		if(userDb != null) {
			userDb.setName(userData.getName());
			userDb.setUniqueId(userData.getUniqueId());
			userDb.setEmailId(userData.getEmailId());
			
		}
		return userRepo.save(userDb);
	}

	@Override
	public ResponseObjects returnClient(String uniqueId) {
		UserData userData = userRepo.findUserByUniqueId(uniqueId);
		
		Products products = restTemplate.getForObject("http://PRODUCT-SERVICE/amazon/products/" + userData.getUniqueId(), Products.class);
		Address address = restTemplate.getForObject("http://ADDRESS-SERVICE/amazon/user_address/" + userData.getUniqueId(), Address.class);
		ResponseObjects responseObjects = new ResponseObjects();
		
		responseObjects.getUserData();
		
		responseObjects.getProducts();
		responseObjects.getAddress();
		
		return responseObjects;
		
	}

	@Override
	public ResponseObjects returnUserAddress(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

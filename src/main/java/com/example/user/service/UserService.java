package com.example.user.service;

import java.util.List;

import com.example.user.entity.UserData;
import com.example.user.responseObject.ResponseObjects;

public interface UserService {
	UserData saveUserToDb(UserData userData);
	UserData getUserByUnique(String uniqueId);
	List<UserData> fetchuserData();
	UserData updateUserData(UserData userData, Long id);
	void deleteById(Long id);
	
	ResponseObjects returnClient(String id);

}

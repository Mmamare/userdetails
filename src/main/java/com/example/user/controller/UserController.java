package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.entity.UserData;
import com.example.user.responseObject.ResponseObjects;
import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/amazon/user/")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("saveuser")
	public UserData saveUser(@RequestBody UserData user) {
		UserData userData = userService.saveUserToDb(user);
		return userData;
	}
	@GetMapping("finduser/{uniqueid}")
	public UserData getUserDetailsByUniqueId(@PathVariable("uniqueid") String uniqueId) {
		UserData user = userService.getUserByUnique(uniqueId);
		return user;
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	@PutMapping("updateuser/{id}")
	public UserData fetchUser(@RequestBody UserData user, @PathVariable long id) {
		
		UserData userData = userService.updateUserData(user, id);
		return userData;
	}
	
	@GetMapping("search/{uniqueid}")
	@CircuitBreaker(name="usercircuitbreaker", fallbackMethod="userFallBackMethod")
	public ResponseEntity<?> getPoduct(@PathVariable("uniqueid") String uniqueId) {
		return new ResponseEntity<Object> (userService.returnClient(uniqueId), HttpStatus.OK);
	}
	
	public ResponseEntity<?> userFllBackMethod(String uniqueId, Exception e){
		return new ResponseEntity<String> ("Product service not responding", HttpStatus.NOT_FOUND);
	}
}

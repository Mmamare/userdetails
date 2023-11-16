package com.example.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.controller.UserController;

@SpringBootTest
class UserApplicationTest {
	
	@Autowired
	private UserController controller;

	@Test
	void test() throws Exception{
		assertThat(controller).isNotNull();
		
	}

}

package com.hcl.hackathon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.controller.UserController;
import com.hcl.hackathon.dao.UserDao;

@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserController userController;
	
	@Test
	public void shouldRegisterUser() {
		
	}
	
	@Test
	public void shouldLoginUser(){
		
	}
}

package com.hcl.hackathon;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.controller.UserController;
import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.Login;

@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Mock
	UserDao userDaoMock;
	
	@Mock
	Login loginMock;
	
	@InjectMocks
	UserController userControllerMock;
	
	@Test
	public void shouldRegisterUser() {
		
	}
	
	@Test
	public void shouldLoginIfRoleIsUser(){
		when(userDaoMock.login(loginMock)).thenReturn("USER");
		Assert.assertEquals("USER",userControllerMock.login(loginMock).getRole());
		Assert.assertEquals("User Login Successful", userControllerMock.login(loginMock).getMessage());
	}
	
	@Test
	public void shouldNotLoginIfRoleIsNull(){
		when(userDaoMock.login(loginMock)).thenReturn(null);
		Assert.assertEquals(null,userControllerMock.login(loginMock).getRole());
		Assert.assertEquals("User Login Failed", userControllerMock.login(loginMock).getMessage());
	}
}

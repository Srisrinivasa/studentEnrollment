package com.hcl.hackathon;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.constants.Constants;
import com.hcl.hackathon.controller.UserController;
import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;

/**
 * Class to test User Controller
 * @author admin
 *
 */

@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Mock
	UserDao userDaoMock;
	
	@Mock
	Login loginMock;
	
	@InjectMocks
	UserController userControllerMock;
	
	@Test
	public void shouldReturnPendingKYCUsers() {
		final UserDetails user1 = new UserDetails();
		user1.setKycStatus(Constants.PENDING);
		final UserDetails user2 = new UserDetails();
		user2.setKycStatus(Constants.PENDING);
		final List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		userDetailsList.add(user1);
		userDetailsList.add(user2);
		when(userDaoMock.findPendingKycUsers()).thenReturn(userDetailsList);
		final List<UserDetails> response = userControllerMock.pendingKYCUser();
		Assert.assertEquals(2, response.size());
		Assert.assertEquals(Constants.PENDING, response.get(0).getKycStatus());
		Assert.assertEquals(Constants.PENDING, response.get(1).getKycStatus());
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

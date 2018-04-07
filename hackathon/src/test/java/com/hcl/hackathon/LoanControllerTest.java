package com.hcl.hackathon;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.constants.Constants;
import com.hcl.hackathon.controller.LoanController;
import com.hcl.hackathon.dao.LoanDao;
import com.hcl.hackathon.domain.LoanDetails;
import com.hcl.hackathon.domain.UserDetails;

@RunWith(SpringRunner.class)
public class LoanControllerTest {

	@Mock
	LoanDao loanDaoMock;
	
	@Mock
	LoanDetails loanDetailsMock;
	
	@InjectMocks
	LoanController loanControllerMock;
	
	@Test
	public void shouldCaptureLoan() {
		
	}
	
	@Test
	public void shouldReturnLoanDetails() {
		final String userId = "nitin@gmail.com";
		final LoanDetails loan1 = new LoanDetails();
		final LoanDetails loan2 = new LoanDetails();
		final List<LoanDetails> loanDetailsList = new ArrayList<LoanDetails>();
		loanDetailsList.add(loan1);
		loanDetailsList.add(loan2);
		when(loanDaoMock.findLoanDetailsByUserId(userId)).thenReturn(loanDetailsList);
		ResponseEntity<?> response = loanControllerMock.getLoanDetails("nitin@gmail.com");
		Assert.assertNotNull(response);
		List<LoanDetails> loandetails= (List<LoanDetails>) response.getBody();
		Assert.assertEquals(2,loandetails.size());
	}
}

package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.dao.LoginDAO;
import com.model.UserDTO;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginService loginservice;
	
	@Mock
	LoginDAO loginDAO;
	
	@Test
	public void shouldValidateUserMethodReturnUserDTO(){
		UserDTO dto = new UserDTO();
		when(loginDAO.validateUser("df", "123")).thenReturn(dto);
		
		Assert.assertEquals(dto, loginservice.validateUser("df", "123"));
	}
}

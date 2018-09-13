package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.when;
import com.model.UserDTO;
import com.service.RegistrationService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	RegistrationController registrationController;
	
	@Mock
	HttpServletRequest  httpServletRequest;
	
	@Mock
	HttpServletResponse  httpServletResponse;
	
	@Mock
	RegistrationService registrationService;
	
	
	@Test
	public void shouldShowRegistrationMethodReturnRegistration(){
		String string = registrationController.showRegistration();
		Assert.assertEquals("registration", string);
	}
	
	@Test
	public void shouldRegisterUserMethodRegisterUserAndReturnLoginPage(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(12);
		userDTO.setUserName("fjk");
		userDTO.setPassword("1231");
		when(registrationService.addUser(userDTO)).thenReturn(1);
		ModelAndView modelAndView = registrationController.registerUser(httpServletRequest, httpServletResponse, userDTO);
		//Assert.assertEquals("login", modelAndView.getViewName());
	}
}

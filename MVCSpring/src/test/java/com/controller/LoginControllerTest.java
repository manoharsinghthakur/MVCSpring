package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;

import com.model.UserDTO;
import com.service.LoginService;

import javafx.beans.binding.When;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@InjectMocks
	LoginController loginController;

	@Mock
	LoginService loginService;
	
	@Mock
	HttpServletRequest  httpServletRequest;
	
	@Mock
	HttpServletResponse  httpServletResponse;
	
	@Test
	public void shouldControllershowLoginMethodReturnModelAndView(){
		ModelAndView modelAndView = loginController.showLogin();
		Assert.assertNotNull(modelAndView);
		Assert.assertEquals("login", modelAndView.getViewName());
		Assert.assertEquals("Please Enter Your Login Details", modelAndView.getModel().get("message"));
	}
	
	@Test
	public void shouldValidateUserMethodReturnWelcome(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("ms");
		when(loginService.validateUser(anyString(), anyString())).thenReturn(userDTO);
		
		ModelAndView modelAndView = loginController.validateUser(httpServletRequest, httpServletResponse, userDTO);
		
		Assert.assertEquals(userDTO.getUserName(),modelAndView.getModel().get("userName"));
		Assert.assertEquals("welcome",modelAndView.getViewName());
		verify(loginService).validateUser(anyString(),anyString());
	}
	
	@Test
	public void shouldValidateUserMethodReturnLogin(){
		UserDTO userDTO = new UserDTO();
		when(loginService.validateUser(anyString(), anyString())).thenReturn(null);
		
		ModelAndView modelAndView = loginController.validateUser(httpServletRequest, httpServletResponse, userDTO);
		
		Assert.assertEquals("login",modelAndView.getViewName());
		verify(loginService).validateUser(anyString(),anyString());
	}
}

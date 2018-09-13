package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dao.RegistrationDAO;
import com.model.UserDTO;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
	
	@InjectMocks
	RegistrationService registrationService;
	
	@Mock
	RegistrationDAO registrationDAO;

	@Test
	public void shouldAddUserMethodReturnUserId(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(5);
		
		when(registrationDAO.addUser(userDTO)).thenReturn(userDTO.getUserId());
		
		Integer userId = registrationService.addUser(userDTO);
		
		verify(registrationDAO).addUser(userDTO);
		Assert.assertEquals(userDTO.getUserId(), userId);
	}
}

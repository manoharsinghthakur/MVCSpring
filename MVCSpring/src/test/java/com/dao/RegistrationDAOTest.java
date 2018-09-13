package com.dao;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.model.UserDTO;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationDAOTest {

@InjectMocks
RegistrationDAO registrationDAO;

@Mock
EntityManager entityManager;

@Mock
UserDTO userDTO;

@Test
public void shouldRegisterUserMethodRegisterUserDTO(){
	doNothing().when(entityManager).persist(userDTO);;
	registrationDAO.addUser(userDTO);
	verify(entityManager).persist(userDTO);
}

}

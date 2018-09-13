package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RegistrationDAO;
import com.model.UserDTO;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Transactional
	public Integer addUser(UserDTO userDTO) {
		System.out.println("inside service");
		return registrationDAO.addUser(userDTO);
	}
}

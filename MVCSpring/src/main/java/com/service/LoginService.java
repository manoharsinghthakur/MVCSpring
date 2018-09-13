package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDAO;
import com.model.UserDTO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	public UserDTO validateUser(String userName, String password){
		return loginDAO.validateUser(userName, password);		
	}
}

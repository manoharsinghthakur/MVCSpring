package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.model.UserDTO;

@Repository
public class LoginDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	public UserDTO validateUser(String userName, String password){
		List<UserDTO> userList = entityManager.createQuery("from UserDTO where userName = '"+userName+"' AND password = '"+password+"'").getResultList(); 
		return userList.size() > 0 ? userList.get(0) : null;
		
	}
}

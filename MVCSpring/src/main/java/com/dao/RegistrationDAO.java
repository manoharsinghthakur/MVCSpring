package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.model.UserDTO;

@Repository
@Transactional
public class RegistrationDAO {

	@PersistenceContext
	EntityManager entityManager;

	public Integer addUser(UserDTO dto) {
		try {

			// entityManager.getTransaction().begin();
			// dto.setUserId(2);
			// dto.setPassword("412");
			// dto.setUserId(1);
			// dto.setUserName("jf");

			entityManager.persist(dto);
			// entityManager.getTransaction().commit();
			System.out.println("Data Save Successfully !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}

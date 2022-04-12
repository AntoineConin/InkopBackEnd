package com.coding.projetweb;

import java.sql.SQLException;
import java.util.List;

import com.coding.models.User;
import com.coding.services.UserDAO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetwebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAllUsers() throws SQLException{
		UserDAO dao = new UserDAO();
		List<User> l =dao.getUsers();

		System.out.println("total users :"+l.size());

		for ( User u : l ){
			System.out.println("User :"+u.getName());
		}
		
	}
}

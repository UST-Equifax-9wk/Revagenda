package com.revature.Revagenda;

import com.revature.Revagenda.controllers.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class RevagendaApplicationTests {
	// The three A's:
	// ARRANGE
	// ACT
	// ASSERT


	private ApplicationContext ac;

	@BeforeEach
	public void setup(@Autowired ApplicationContext ac) {
		this.ac = ac;
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(ac.getBean(UserController.class));
	}

}

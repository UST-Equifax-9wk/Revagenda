package com.revature.Revagenda;

import com.revature.Revagenda.dto.NewUserDto;
import com.revature.Revagenda.entities.Auth;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.services.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {
		"com.revature.Revagenda.controllers",
		"com.revature.Revagenda.services",
		"com.revature.Revagenda.repositories",
		"com.revature.Revagenda.security"})
public class RevagendaApplication {
	private static Logger logger = LogManager.getLogger("fileLogger");
	public static void main(String[] args) throws NoResultsException {
		ApplicationContext iocContainer = SpringApplication.run(RevagendaApplication.class, args);

		User user = new User();
		user.setFirstName("kyle");
		user.setLastName("Plummer");
		user.setUsername("kplummer");

		Auth auth = new Auth();
		auth.setUsername("kplummer");
		auth.setPassword("password");

		NewUserDto dto = new NewUserDto(user, auth);
		System.out.println(dto);





	}

}

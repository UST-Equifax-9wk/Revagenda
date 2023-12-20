package com.revature.Revagenda;

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

		String testString = "testString";
		AuthService authService = iocContainer.getBean(AuthService.class);
		String hash = authService.hash(testString);
		if(authService.checkHash(testString, hash)) {
			logger.fatal("Hash test success");
		} else {
			logger.fatal("Bad hash oh no!");
		}



	}

}

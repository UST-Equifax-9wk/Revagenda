package com.revature.Revagenda;

import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.services.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {
		"com.revature.Revagenda.controllers",
		"com.revature.Revagenda.services",
		"com.revature.Revagenda.repositories"})
public class RevagendaApplication {

	public static void main(String[] args) throws NoResultsException {
		ApplicationContext iocContainer = SpringApplication.run(RevagendaApplication.class, args);


	}

}

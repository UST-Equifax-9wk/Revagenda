package com.revature.Revagenda;

import com.revature.Revagenda.entities.TestEntity;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.repositories.TestRepository;
import com.revature.Revagenda.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {
		"com.revature.Revagenda.beans",
		"com.revature.Revagenda.controllers",
		"com.revature.Revagenda.services",
		"com.revature.Revagenda.repositories"})
public class RevagendaApplication {

	public static void main(String[] args) {
		ApplicationContext iocContainer = SpringApplication.run(RevagendaApplication.class, args);

		UserService service = iocContainer.getBean(UserService.class);
		service.saveUser(new User("Kyle", "Plummer", "kplummer", "password"));
		service.saveUser(new User("Christopher", "Pratt", "cpratt", "knope2012"));
		service.saveUser(new User("Rupert", "Grint", "rweasley", "avadavakadavra"));
		service.saveUser(new User("Andrew", "Garfield", "spidey", "PassW0rd123!"));

		List<User> gNames = null;
		try {
			gNames = service.findUsersByLastInitial('G');
		} catch(NoResultsException e) {
			//...
			e.printStackTrace();
		}
		System.out.println(gNames);

		TestRepository testRepo = iocContainer.getBean(TestRepository.class);
		testRepo.save(new TestEntity("testValue"));



//		RepositoryBean repo = iocContainer.getBean(RepositoryBean.class);
//		User newUser = new User("Kyle", "Plummer", "kplummer", "password");
//		repo.save(newUser);
//		User anotherNewUSer = new User("Christopher", "Plummer", "cplummer", "password");
//		repo.save(anotherNewUSer);
//		User foundUser = repo.findByUsername("kplummer").get();
//		System.out.println("found user by username: " + foundUser);
//		foundUser = repo.findUserWhereLastNameStartsWithChar('P').get();
//		System.out.println("found user by last name with character: " + foundUser);
//		List<User> usersList = repo.findUsersWhereLastNameStartsWithChar('P');
//		System.out.println(usersList);
//		List<User> criteriaList = repo.findUsersByFirstName("Kyle");
//		System.out.println(criteriaList);

	}

}

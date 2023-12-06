package com.revature.Revagenda;

import com.revature.Revagenda.exceptions.NoResultsException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {
		"com.revature.Revagenda.beans",
		"com.revature.Revagenda.controllers",
		"com.revature.Revagenda.services",
		"com.revature.Revagenda.repositories"})
public class RevagendaApplication {

	public static void main(String[] args) throws NoResultsException {
		ApplicationContext iocContainer = SpringApplication.run(RevagendaApplication.class, args);
//
//		UserService userService = iocContainer.getBean(UserService.class);
//		TaskService taskService = iocContainer.getBean(TaskService.class);
//		User kyle = new User("Kyle", "Plummer", "kplummer", "password");
//		//userService.saveUser(kyle);
//
//		Task task = new Task("title", "desc", "due date", kyle);
//		Set<Task> taskSet = new HashSet<>();
//		taskSet.add(task);
//		kyle.setTasks(taskSet);
//
//		//taskService.saveOrUpdate(taskSet);
//
//		userService.saveUser(kyle);
//
//		User retrievedUser = userService.findUserAndTasks("kplummer");
//		System.out.println(retrievedUser);
//		System.out.println(retrievedUser.getTasks());



//		List<User> gNames = null;
//		try {
//			gNames = userService.findUsersByLastInitial('P');
//		} catch(NoResultsException e) {
//			//...
//			e.printStackTrace();
//		}
//		System.out.println(gNames);

		//TestRepository testRepo = iocContainer.getBean(TestRepository.class);
		//testRepo.save(new TestEntity("testValue"));//can't auto-generate keys



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

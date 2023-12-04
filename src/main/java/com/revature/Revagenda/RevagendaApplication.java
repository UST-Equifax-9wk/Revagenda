package com.revature.Revagenda;

import com.revature.Revagenda.beans.BeanA;
import com.revature.Revagenda.beans.ComponentBean;
import com.revature.Revagenda.controllers.ControllerBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.revature.Revagenda.beans",
		"com.revature.Revagenda.controllers",
		"com.revature.Revagenda.services",
		"com.revature.Revagenda.repositories"})
public class RevagendaApplication {

	public static void main(String[] args) {
		ApplicationContext iocContainer = SpringApplication.run(RevagendaApplication.class, args);


		ComponentBean bean = (ComponentBean)iocContainer.getBean("ComponentBean");
		bean.whoAmI();
		BeanA beanA = (BeanA)iocContainer.getBean("BeanA");
		beanA.test();


		//This is designed to demonstrate the program flow of a 3-tier spring server
		ControllerBean controller = iocContainer.getBean(ControllerBean.class);
		String name = "myObject";
		Object obj = "{\"firstName\":\"Kyle\", \"lastName\":\"Plummer\"}";
		controller.post(name, obj);

		//...

		String retrievedObject = (String)controller.get("myObject");
		System.out.println("Object retrieved from store: \n" + retrievedObject);






	}

}

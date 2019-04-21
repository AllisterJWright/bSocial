package com.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daoRepository.UserDaoRepo;
import com.models.User;

public class MainDriver {

	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static UserDaoRepo UDR = appContext.getBean("userDaoRepo", UserDaoRepo.class);
	//public static User U = appContext.getBean("Users", User.class);
public static void main(String[] args) {
	User user = new User("AP","1234","AP1234@yahoo.com","J","Image");
	UDR.insert(user);
}
}

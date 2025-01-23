package com.jdbc;

import com.jdbc.Entity.User;
import com.jdbc.dao.UserDaoImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication	//It is the combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan 
public class SpringbootprojectApplication implements CommandLineRunner {

	@Autowired
	private UserDaoImple userDaoImple;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDaoImple.createTable());

		//Creating User
		this.createUser();

	}

	public void createUser() throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user ID");
		Integer userId = Integer.parseInt(br.readLine());

		System.out.println("Enter user Name");
		String userName = br.readLine();

		System.out.println("Enter user Age");
		Integer userAge = Integer.parseInt(br.readLine());

		System.out.println("Enter user City");
		String userCity = br.readLine();

		User user = new User();
		user.setId(userId);
		user.setName(userName);
		user.setAge(userAge);
		user.setCity(userCity);

		int i = this.userDaoImple.insertUser(user);

		System.out.println("User Added");

	}

}

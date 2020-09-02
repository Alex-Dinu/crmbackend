package com.ceme.crm;

import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.entity.InteractionModel;
import com.ceme.crm.repository.CustomerRepository;
import com.ceme.crm.repository.InteractionRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
// Tell Spring boot where the repos are.
@EnableMongoRepositories(basePackages = "com.ceme.crm.repository")
@OpenAPIDefinition // http://localhost:8080/swagger-ui.html
public class CrmApplication {

	@Autowired
	private InteractionRepository interactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
		displayRunning();
	}

	private static void displayRunning() {
		StringBuilder message = new StringBuilder()
				.append(".----------------.  .----------------.  .----------------. ")
				.append(System.getProperty("line.separator"))
				.append("| .--------------. || .--------------. || .--------------. |")
				.append(System.getProperty("line.separator"))
				.append("| |     ______   | || |  _______     | || | ____    ____ | |")
				.append(System.getProperty("line.separator"))
				.append("| |     ______   | || |  _______     | || | ____    ____ | |")
				.append(System.getProperty("line.separator"))
				.append("| |   .' ___  |  | || | |_   __ \\    | || ||_   \\  /   _|| |")
				.append(System.getProperty("line.separator"))
				.append("| |  / .'   \\_|  | || |   | |__) |   | || |  |   \\/   |  | |")
				.append(System.getProperty("line.separator"))
				.append("| |  | |         | || |   |  __ /    | || |  | |\\  /| |  | |")
				.append(System.getProperty("line.separator"))
				.append("| |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || | _| |_\\/_| |_ | |")
				.append(System.getProperty("line.separator"))
				.append("| |   `._____.'  | || | |____| |___| | || ||_____||_____|| |")
				.append(System.getProperty("line.separator"))
				.append("| |              | || |              | || |              | |")
				.append(System.getProperty("line.separator"))
				.append("| '--------------' || '--------------' || '--------------' |")
				.append(System.getProperty("line.separator"))
				.append("'----------------'  '----------------'  '----------------'")
				.append(System.getProperty("line.separator"));

		System.out.println("\u001B[32m" + message.toString() + "\u001B[0m");

	}
}

package com.poc.pocrestfulapi;

import com.poc.pocrestfulapi.model.Employee;
import com.poc.pocrestfulapi.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PocRestfulApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(PocRestfulApiApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PocRestfulApiApplication.class, args);

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository) {
		return (args) -> {
            employeeRepository.save(new Employee("Gustavo", "Ponce", true));
            employeeRepository.save(new Employee("John", "Smith", true));
            employeeRepository.save(new Employee("Jim ", "Morrison", false));
            employeeRepository.save(new Employee("David", "Gilmour", true));
			logger.info("The sample data has been generated");
		};
	}

	@Profile("dev")
	@Bean
	public String devBean() {
		return "dev";
	}

	@Profile("qa")
	@Bean
	public String qaBean() {
		return "qa";
	}

	@Profile("prod")
	@Bean
	public String prodBean() {
		return "prod";
	}

}

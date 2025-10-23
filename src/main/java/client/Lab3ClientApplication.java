package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application that acts as a Spring Config client
 * reading yml files from a Git repository pointed by a server project
 * whose server and port is specified in application.yml
 */
@SpringBootApplication
public class Lab3ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab3ClientApplication.class, args);
	}

}

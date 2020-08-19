package com.dxctraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootapplication equivalent to 3 things 1)@Configuration : so we dont
 *                        have to provide on our own 2)@ComponentScan: so we
 *                        dont have to provide on our own 3) @AutoConfiguration
 *                        so we dont have to provide on our own
 */
@SpringBootApplication
public class ProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMain.class, args);

	}

}

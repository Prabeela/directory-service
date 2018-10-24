package io.pivotal.workshop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.controller.SimpleController;
import io.pivotal.repository.DirectoryRepository;
import io.pivotal.workshop.domain.Directory;
import io.pivotal.workshop.domain.Person;

@SpringBootApplication
@EnableJpaRepositories("io.pivotal.repository")
@ComponentScan(basePackageClasses=SimpleController.class)
public class DirectoyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectoyServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner addPersons(DirectoryRepository repo) {
		return args ->{
			List<Person> people = new ArrayList<Person>() {
				private static final long serialVersionUID=6851604214661500516L;
				{
					add(new Person("John","Doe","john@email.com","Denver","100"));
					add(new Person("Sam","Lon","john@email.com","Denver","100"));
				}
			};
			repo.save(new Directory("my-directory",people));
		};
	}
}

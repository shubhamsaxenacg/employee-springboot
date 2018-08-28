package io.javabrains.springbootstarter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.javabrains.springbootstarter.pojo.Topics;
import io.javabrains.springbootstarter.service.TopicService;

@SpringBootApplication
public class CourseApiApp {


	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class,args);

	}

	@Bean
	public CommandLineRunner addToDatabase(TopicService service) {
		return (args)->{
			service.addTopic(new Topics(1,"Aashish","adlkfj"));
			service.addTopic(new Topics(2,"Aashish","adlkfj"));
			service.addTopic(new Topics(3,"Aashish","adlkfj"));
			service.addTopic(new Topics(4,"Aashish","adlkfj"));
			service.addTopic(new Topics(5,"Aashish","adlkfj"));
			service.addTopic(new Topics(6,"Aashish","adlkfj"));
			service.addTopic(new Topics(7,"Aashish","adlkfj"));
			
			
		};
	}
	
}

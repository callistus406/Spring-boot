package com.callistus.dataJPA;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.callistus.dataJPA.models.Author;
import com.callistus.dataJPA.models.Video;
import com.callistus.dataJPA.repositories.AuthorRepository;
import com.callistus.dataJPA.repositories.VideoRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DataJpaApplication.class);
		app.setAdditionalProfiles("default");
		app.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository) {

		return args -> {

			// for (int i = 0; i < 100; i++) {

			// 	Faker faker = new Faker();
			// 	var author = Author.builder()
			// 	.firstName(faker.name().firstName())
			// 	.lastName(faker.name().lastName())
			// 	.age(faker.number().numberBetween(19,50))
			// 	.email("faker"+i+"@gmail.com")
			// 	.createdAt(LocalDateTime.now())
			// 	.updatedAt(LocalDateTime.now())
			// 	.build();

			// 	repository.save(author);
			// }

			// var video = Video.builder().name("Lecture 2").length(4).createdAt(LocalDateTime.now()).build();
			// videoRepository.save(video);
			// repository.findAllByFirstName("chase");
		};
	}

}

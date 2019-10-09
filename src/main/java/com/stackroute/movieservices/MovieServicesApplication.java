package com.stackroute.movieservices;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.stackroute.movieservices.repository")
public class MovieServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServicesApplication.class, args);
	}
}

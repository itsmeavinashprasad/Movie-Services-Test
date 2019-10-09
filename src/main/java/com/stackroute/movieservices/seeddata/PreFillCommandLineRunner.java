package com.stackroute.movieservices.seeddata;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:application.properties")
public class PreFillCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;


    @Value("${title}")
    private String title;

    @Value("${voteAverage}")
    private float voteAverage;

    @Value("${releaseDate}")
    private String releaseDate;

    @Value("${adult}")
    private boolean adult;

    @Value("${overview}")
    private String overview;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-> Pre-Fill using CommandLineRunner");
        movieRepository.save(new Movie(
                4,
                "Movie 4",
                (float) 7.4,
                "2009-04-04",
                true,
                "Overview 4"
        ));

        movieRepository.save(new Movie(
                5,
                "Movie 5",
                (float) 7.5,
                "2009-05-05",
                true,
                "Overview 5"
        ));
        movieRepository.save(new Movie(
                6,
                "Movie 6",
                (float) 7.6,
                "2009-06-06",
                false,
                "Overview 6"
        ));
        movieRepository.save(new Movie(
                0,
                title,
                voteAverage,
                releaseDate,
                adult,
                overview
        ));
    }
}

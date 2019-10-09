package com.stackroute.movieservices.seeddata;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PreFillApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("-> Pre-Fill using ApplicationListener<ContextRefreshedEvent>");
        movieRepository.save(new Movie(
                1,
                "Movie 1",
                (float) 7.1,
                "2009-01-01",
                true,
                 "Overview 1"
        ));

        movieRepository.save(new Movie(
                2,
                "Movie 2",
                (float) 7.2,
                "2009-02-02",
                true,
                "Overview 2"
        ));
        movieRepository.save(new Movie(
                3,
                "Movie 3",
                (float) 7.3,
                "2009-03-03",
                false,
                "Overview 3"
        ));

    }
}

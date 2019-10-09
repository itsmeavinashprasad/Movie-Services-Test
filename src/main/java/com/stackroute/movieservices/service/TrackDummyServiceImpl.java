package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackDummyServiceImpl implements MovieService {
    @Override
    public Movie saveMovie(Movie movie) throws MovieException {
        return null;
    }

    @Override
    public Movie deleteMovie(int id) throws MovieException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovie(int id) throws MovieException {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieException {
        return null;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return null;
    }
}

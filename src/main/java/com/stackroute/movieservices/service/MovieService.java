package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieException;
    public Movie deleteMovie(int id) throws MovieException;
    public List<Movie> getAllMovies();
    public Movie getMovie(int id) throws MovieException;
    public Movie updateMovie(Movie movie)throws MovieException;
    public List<Movie> findByTitle(String title);
}

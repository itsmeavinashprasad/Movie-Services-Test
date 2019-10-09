package com.stackroute.movieservices.service;

import com.stackroute.movieservices.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservices.exceptions.MovieNotFoundException;
import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieException;
import com.stackroute.movieservices.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl() {
    }

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieException {
        if (movieRepository.existsById(movie.getId()))
            throw new MovieAlreadyExistsException("saveMovie(): Movie[id=" + movie.getId() + "] already exists in database");
        return movieRepository.save(movie);
    }

    @Override
    public Movie deleteMovie(int id) throws MovieException {
        if (!movieRepository.existsById(id))
            throw new MovieNotFoundException("deleteMovie(): Movie[id=" + id + "] does not exist in database");
        Movie movie = getMovie(id);
        movieRepository.deleteById(id);
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) throws MovieException {
        if (!movieRepository.existsById(id))
            throw new MovieNotFoundException("getMovie(): Movie[id=" + id + "] does not exist in database");
        return movieRepository.findById(id).get();
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieException {
        if (!movieRepository.existsById(movie.getId()))
            throw new MovieNotFoundException("updateMovie(): Movie[id=" + movie.getId() + "] does not exist in database");
        Movie newMovie = movieRepository.findById(movie.getId()).get();
        if (movie.getTitle() != null) {
            newMovie.setTitle(movie.getTitle());
        }
        if (movie.getVoteAverage() != 0) {
            newMovie.setVoteAverage(movie.getVoteAverage());
        }
        if (movie.getAdult() == null) {
            newMovie.setAdult(movie.getAdult());
        }
        if (movie.getOverview() != null) {
            newMovie.setOverview(movie.getOverview());
        }
        if (movie.getReleaseDate() != null) {
            newMovie.setReleaseDate(movie.getReleaseDate());
        }
        movieRepository.save(newMovie);
        return newMovie;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}

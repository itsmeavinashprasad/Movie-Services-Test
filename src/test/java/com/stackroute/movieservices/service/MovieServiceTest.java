package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservices.exceptions.MovieException;
import com.stackroute.movieservices.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    private Movie movie;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    private List<Movie> movieList = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movie = new Movie(
                1,
                "Movie 1",
                (float) 7.1,
                "2009-01-01",
                true,
                "Overview 1"
        );

        movieList = new ArrayList<Movie>();
        movieList.add(movie);
    }

    @Test
    public void testSaveMovieSuccess() throws MovieException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        when(movieRepository.existsById((Integer) any())).thenReturn(false);
        Movie savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie, savedMovie);

        //verify here verifies that movieRepository save method is only called once
        verify(movieRepository, times(1)).save(movie);
        verify(movieRepository, times(1)).existsById(movie.getId());
    }

    @Test(expected = MovieException.class)
    public void testSaveMovieFailure() throws MovieException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        when(movieRepository.existsById((Integer) any())).thenReturn(true);
        Movie savedMovie = movieService.saveMovie(movie);
    }

}

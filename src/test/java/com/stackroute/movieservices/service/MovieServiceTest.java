package com.stackroute.movieservices.service;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservices.exceptions.MovieException;
import com.stackroute.movieservices.repository.MovieRepository;
import io.swagger.models.auth.In;
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
        movie = new Movie();
        movieList = new ArrayList<Movie>();
    }

    @Test
    public void testSaveMovieSuccess() throws MovieException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        when(movieRepository.existsById((Integer) any())).thenReturn(false);
        movieService.saveMovie(movie);

        //verify here verifies that movieRepository save method is only called once
        verify(movieRepository, times(1)).save(movie);
        verify(movieRepository, times(1)).existsById(movie.getId());
    }

    @Test(expected = MovieException.class)
    public void testSaveMovieFailure() throws MovieException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        when(movieRepository.existsById((Integer) any())).thenReturn(true);
        movieService.saveMovie(movie);
    }

    @Test
    public void testDeleteMovieSuccess() throws MovieException{
        when(movieRepository.findById((Integer) any())).thenReturn(java.util.Optional.ofNullable(movie));
        when(movieRepository.existsById((Integer) any())).thenReturn(true);
        movieService.deleteMovie(movie.getId());

        verify(movieRepository, times(1)).deleteById(movie.getId());
        verify(movieRepository, times(2)).existsById(movie.getId());
        verify(movieRepository, times(1)).findById(movie.getId());
    }

    @Test(expected = MovieException.class)
    public void testDeleteMovieFailure() throws MovieException{
        when(movieRepository.findById((Integer) any())).thenReturn(java.util.Optional.ofNullable(movie));
        when(movieRepository.existsById((Integer) any())).thenReturn(false);
        movieService.deleteMovie(movie.getId());
    }

    @Test
    public void testGetAllMoviesSuccess(){
        when(movieRepository.findAll()).thenReturn(movieList);
        movieService.getAllMovies();

        verify(movieRepository, times(1)).findAll();
    }

    @Test
    public void testGetMovieSuccess() throws MovieException{
        when(movieRepository.existsById((Integer) any())).thenReturn(true);
        when(movieRepository.findById((Integer) any())).thenReturn(java.util.Optional.ofNullable(movie));
        movieService.getMovie(movie.getId());

        verify(movieRepository, times(1)).existsById(movie.getId());
        verify(movieRepository, times(1)).findById(movie.getId());
    }

    @Test(expected = MovieException.class)
    public void testGetMovieFailure() throws MovieException{
        when(movieRepository.existsById((Integer) any())).thenReturn(false);
        movieService.getMovie(movie.getId());
    }

    @Test
    public void testUpdateMovieSuccess() throws MovieException{
        when(movieRepository.existsById((Integer) any())).thenReturn(true);
        when(movieRepository.findById((Integer) any())).thenReturn(java.util.Optional.ofNullable(movie));
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        movieService.updateMovie(movie);

        verify(movieRepository, times(1)).existsById(movie.getId());
        verify(movieRepository, times(1)).findById(movie.getId());
        verify(movieRepository, times(1)).save(movie);
    }

    @Test(expected = MovieException.class)
    public void testUpdateMovieFailure() throws MovieException{
        when(movieRepository.existsById((Integer) any())).thenReturn(false);
        movieService.updateMovie(movie);
    }

    @Test
    public void testFindByTitle() {
        when(movieRepository.findByTitle((String) any())).thenReturn(movieList);
        movieService.findByTitle(movie.getTitle());

        verify(movieRepository, times(1)).findByTitle(movie.getTitle());
    }
}

package com.stackroute.movieservices.repository;

import com.stackroute.movieservices.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie movie, movie2;

    @Before
    public void setUp() {
        movie = new Movie(
                1,
                "Movie 1",
                (float) 7.1,
                "2009-01-01",
                true,
                "Overview 1"
        );
        movie2 = new Movie(
                2,
                "Movie 2",
                (float) 7.2,
                "2009-02-02",
                false,
                "Overview 2"
        );
    }

    @After
    public void tearDown() {
        movieRepository.deleteAll();
        this.movie = null;
        this.movie2 = null;
    }

    @Test
    public void testSaveMovie() {
        Movie fetchMovie = movieRepository.save(movie);
        Assert.assertEquals("Movie 1", fetchMovie.getTitle());
    }

    @Test
    public void testSaveMovieFailure() {
        Movie fetchMovie = movieRepository.save(movie);
        Assert.assertNotSame(movie2, movie);
    }

    @Test
    public void testDeleteByIdSuccess(){
        Movie savedMovie = movieRepository.save(movie);
        movieRepository.deleteById(savedMovie.getId());
        Assert.assertFalse(movieRepository.existsById(savedMovie.getId()));

    }

    @Test
    public void testDeleteByIdFailure(){
        Movie savedMovie = movieRepository.save(movie);
        Movie savedMovie2 = movieRepository.save(movie2);
        movieRepository.deleteById(savedMovie.getId());
        Assert.assertTrue(movieRepository.existsById(savedMovie2.getId()));
    }

    @Test
    public void testGetMovieSuccess(){
        Movie savedMovie = movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(savedMovie.getId()).get();
        Assert.assertSame(fetchMovie, savedMovie);
    }

    @Test
    public void testGetMovieFailure(){
        Movie savedMovie = movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(savedMovie.getId()).get();
        Assert.assertNotSame(fetchMovie, movie2);
    }

    @Test
    public void testGetAllMovie() {
        Movie movie1 = new Movie(
                1,
                "Movie 1",
                (float) 7.1,
                "2009-01-01",
                true,
                "Overview 1"
        );

        System.out.println("Saving: " + movieRepository.save(movie1).toString());
        System.out.println("Saving: " + movieRepository.save(movie2).toString());

        List<Movie> movieList = movieRepository.findAll();
        Assert.assertEquals("Movie 2", movieList.get(1).getTitle());
    }
}

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

    private Movie movie;

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
    }

    @After
    public void tearDown() {
//        movieRepository.deleteAll();
//        this.movie = null;
    }

    @Test
    public void testSaveMovie() {
        Movie fetchMovie = movieRepository.save(movie);
        Assert.assertEquals(1, fetchMovie.getId());
    }

    @Test
    public void testSaveMovieFailure() {
        Movie testMovie = new Movie(
                1,
                "Movie 1",
                (float) 7.1,
                "2009-01-01",
                true,
                "Overview 1"
        );
        Movie fetchMovie = movieRepository.save(movie);
        Assert.assertNotSame(testMovie, movie);
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
        Movie movie2 = new Movie(
                2,
                "Movie 2",
                (float) 7.2,
                "2009-02-02",
                false,
                "Overview 2"
        );

        System.out.println("Saving: " + movieRepository.save(movie1).toString());
        System.out.println("Saving: " + movieRepository.save(movie2).toString());

        List<Movie> movieList = movieRepository.findAll();
        Assert.assertEquals("Movie 2", movieList.get(1).getTitle());
    }


}

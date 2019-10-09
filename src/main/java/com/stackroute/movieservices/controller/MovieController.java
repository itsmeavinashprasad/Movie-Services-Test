package com.stackroute.movieservices.controller;

import com.stackroute.movieservices.domain.Movie;
import com.stackroute.movieservices.exceptions.MovieException;
import com.stackroute.movieservices.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "Movie Services Rest API")
public class MovieController {
    private MovieService movieService;

    public MovieController() {
    }

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "Add a Movie")
    @PostMapping(value = "movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieException {
        System.out.println("saveMovie(): "+ movie.toString());
        return new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a Movie from Database using movie_id")
    @DeleteMapping(value = "movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) throws MovieException{
        System.out.println("deleteMovie(): id = "+ id);
        return new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.OK);
    }

    @ApiOperation(value = "List of All movies present in the Database")
    @GetMapping(value = "movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get information about a Movie providing its movie_id")
    @GetMapping(value = "movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id) throws MovieException{
            return new ResponseEntity<Movie>(movieService.getMovie(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Update information of a Movie")
    @PutMapping(value = "movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) throws MovieException{
            System.out.println("updateMovie(): "+ movie.toString());
            return new ResponseEntity<Movie>(movieService.updateMovie(movie), HttpStatus.OK);
    }

    @ApiOperation(value = "List of all movies of given title")
    @GetMapping("movieByTitle/{title}")
    public ResponseEntity<?> findMovieByTitle(@PathVariable String title){
        return new ResponseEntity<List<Movie>>(movieService.findByTitle(title), HttpStatus.OK);
    }
}

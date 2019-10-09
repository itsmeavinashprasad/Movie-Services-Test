package com.stackroute.movieservices.repository;

import com.stackroute.movieservices.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select movie from Movie movie where movie.title like ?1")
    List<Movie> findByTitle(String title);

}

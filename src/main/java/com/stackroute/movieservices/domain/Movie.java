package com.stackroute.movieservices.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Movie")
@ApiModel(description = "All details about the Movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(value = "id")
    @ApiModelProperty(value = "Movie Id")
    private int id;

    @JsonProperty(value = "title")
    @ApiModelProperty(value = "Movie Title")
    private String title;

    @JsonProperty(value = "vote_average")
    @Column(name = "vote_average")
    @ApiModelProperty(value = "Movie average voted rating")
    private float voteAverage;

    @JsonProperty(value = "release_date")
    @Column(name = "release_date")
    @ApiModelProperty(value = "Movie release date")
    private String releaseDate;

    @JsonProperty(value = "adult")
    @ApiModelProperty(value = "Movie rating adult or not")
    private Boolean adult;

    @JsonProperty(value = "overview")
    @ApiModelProperty(value = "Movie Overview")
    private String overview;



    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", releaseDate='" + releaseDate + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                '}';
    }
}

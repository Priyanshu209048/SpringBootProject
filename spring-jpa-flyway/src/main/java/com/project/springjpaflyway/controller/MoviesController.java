package com.project.springjpaflyway.controller;

import com.project.springjpaflyway.model.Movie;
import com.project.springjpaflyway.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/movies")
public class MoviesController {

    private final MovieRepository movieRepository;

    @Autowired
    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping()
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

}

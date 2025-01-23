package com.project.springjpaflyway.repository;

import com.project.springjpaflyway.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

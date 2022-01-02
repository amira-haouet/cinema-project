package org.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {

	
	List<Movie> findByScenaristeNomSc(String nomSc);
}

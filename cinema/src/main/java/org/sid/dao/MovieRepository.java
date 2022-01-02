package org.sid.dao;

import java.util.List;

import org.sid.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;




public interface MovieRepository extends JpaRepository<Movie, Long> {

	
	List<Movie> findByScenaristeNomSc(String nomSc);
}

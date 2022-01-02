package org.sid.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




public interface MovieRepository extends JpaRepository<Movie, Long> {

	
	List<Movie> findByScenaristeNomSc(String nomSc);
}

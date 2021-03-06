package org.sid.dao;

import java.util.List;

import org.sid.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByScenaristeNomSc(String nomSc);
}

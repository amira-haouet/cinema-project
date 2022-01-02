package org.sid.dao;

import java.util.List;

import org.sid.entities.Cinema;
import org.sid.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long> {

	List<Film> findByScenaristeNomSc(String s);

}

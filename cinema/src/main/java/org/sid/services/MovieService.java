package org.sid.services;

import java.util.List;

import org.sid.entities.Movie;
import org.springframework.data.domain.Page;



public interface MovieService {
	
	Movie saveMedecin(Movie m);
	Movie updateMedecin(Movie m);
	void deleteMedecin(Movie m);
	void deleteMedecinById(Long id);
	Movie getMedecin(Long id);
	List<Movie> getAllMedecin();
	
	Page<Movie>  getAllmedecinPage(int page , int size);
	
	List<Movie> findMedecinBySpecialite(String s);
}

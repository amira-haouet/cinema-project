package org.sid.services;

import java.util.List;

import org.sid.entities.Film;
import org.springframework.data.domain.Page;


public interface ICinemaInitService {
	public void initVilles();
	public void initCinemas();
	public void initSalles();
	public void initPlaces();
	public void initSeances();
	public void initCategories();
	public void initFilms();
	public void initProjections();
	public void initTickets();
	
	Film saveMedecin(Film m);
	Film updateMedecin(Film m);
	void deleteMedecin(Film m);
	void deleteMedecinById(Long id);
	Film getMedecin(Long id);
	List<Film> getAllMedecin();
	
	Page<Film>  getAllmedecinPage(int page , int size);
	
	List<Film> findMedecinBySpecialite(String s);
}

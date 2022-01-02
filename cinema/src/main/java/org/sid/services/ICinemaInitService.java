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
	

}

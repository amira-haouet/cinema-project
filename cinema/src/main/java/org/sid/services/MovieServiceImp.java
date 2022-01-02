package org.sid.services;

import java.util.List;


import org.sid.entities.Movie;
import org.sid.entities.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Movie saveMedecin(Movie m) {
		return movieRepository.save(m);
	}

	@Override
	public Movie updateMedecin(Movie m) {
		return movieRepository.save(m);
	}

	@Override
	public void deleteMedecin(Movie m) {
		movieRepository.delete(m);

	}

	@Override
	public void deleteMedecinById(Long id) {
		movieRepository.deleteById(id);

	}

	@Override
	public Movie getMedecin(Long id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public List<Movie> getAllMedecin() {
		return movieRepository.findAll();
	}

	@Override
	public Page<Movie> getAllmedecinPage(int page, int size) {
		return  movieRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Movie> findMedecinBySpecialite(String s) {
		return movieRepository.findByScenaristeNomSc(s);
		
	}

}

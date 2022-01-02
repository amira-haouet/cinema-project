package org.sid.web;

package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Movie;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping("/movie/api")
@CrossOrigin
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> getAllMedecin() {
		return movieService.getAllMedecin();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Movie getMedecinById(@PathVariable("id") Long id) {
		return movieService.getMedecin(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteMedecinById(@PathVariable("id") Long id) {
		movieService.deleteMedecinById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Movie updateMedecin(@RequestBody Movie m) {
		return movieService.updateMedecin(m);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie saveMedecin(@RequestBody Movie m) {
		return movieService.saveMedecin(m);
	}

	@GetMapping("/page")
	public Page<Movie> showPage(@RequestParam(name = "p", defaultValue = "0") int page) {
		Page<Movie> p = movieService.getAllmedecinPage(page, 3);
		return p;
	}

	@RequestMapping(value = "/findSpec/{s}", method = RequestMethod.GET)
	public List<Movie> getBySpecialite(@PathVariable("s") String s) {
		System.out.println(s);
		return movieService.findMedecinBySpecialite(s);
	}

}

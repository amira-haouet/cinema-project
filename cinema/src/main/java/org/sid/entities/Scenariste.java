package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Scenariste {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSc;
	private String nomSc;
	private String prenomSc ;
	
	@OneToMany (mappedBy= "scenariste")
	//(cascade = CascadeType.ALL, mappedBy = "scenariste", orphanRemoval = true)

	@JsonIgnore
	private List<Movie> movies;
	
	
	public Scenariste() {
		super();
	
	}


	public Long getIdSc() {
		return idSc;
	}


	public void setIdSc(Long idSc) {
		this.idSc = idSc;
	}


	public String getNomSc() {
		return nomSc;
	}


	public void setNomSc(String nomSc) {
		this.nomSc = nomSc;
	}


	public String getPrenomSc() {
		return prenomSc;
	}


	public void setPrenomSc(String prenomSc) {
		this.prenomSc = prenomSc;
	}


	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}


	public Scenariste(Long idSc, String nomSc, String prenomSc, List<Movie> movies) {
		super();
		this.idSc = idSc;
		this.nomSc = nomSc;
		this.prenomSc = prenomSc;
		this.movies = movies;
	}
	
	
	
}

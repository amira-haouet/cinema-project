package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovie;
	private String titre;
	private Integer prixTicket;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSortie;
	private String genre;

	@ManyToOne
	private Scenariste scenariste;

	public Movie() {
		super();

	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getPrixTicket() {
		return prixTicket;
	}

	public void setPrixTicket(Integer prixTicket) {
		this.prixTicket = prixTicket;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Movie(Long idMovie, String titre, Integer prixTicket, Date dateSortie, String genre, Scenariste scenariste) {
		super();
		this.idMovie = idMovie;
		this.titre = titre;
		this.prixTicket = prixTicket;
		this.dateSortie = dateSortie;
		this.genre = genre;
		this.scenariste = scenariste;
	}

	public Scenariste getScenariste() {
		return scenariste;
	}

	public void setScenariste(Scenariste scenariste) {
		this.scenariste = scenariste;
	}

	public Movie(Long idMovie, String titre, Integer prixTicket, Date dateSortie, String genre) {
		super();
		this.idMovie = idMovie;
		this.titre = titre;
		this.prixTicket = prixTicket;
		this.dateSortie = dateSortie;
		this.genre = genre;
	}

	public Movie(String titre, Integer prixTicket, Date dateSortie, String genre) {
		super();
		this.titre = titre;
		this.prixTicket = prixTicket;
		this.dateSortie = dateSortie;
		this.genre = genre;
	}

}

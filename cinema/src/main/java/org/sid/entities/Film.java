package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Movie;
import com.example.demo.service.MovieService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Film {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private double duree;
	private String realisateur,description,photo;
	private Date dateSortie;
	@OneToMany(mappedBy = "film")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Projection> projections;
	@ManyToOne
	private Categorie categorie;
	public Film(Long id, String titre, double duree, String realisateur, String description, String photo,
			Date dateSortie, Collection<Projection> projections, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.dateSortie = dateSortie;
		this.projections = projections;
		this.categorie = categorie;
	}
	public Film() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public Collection<Projection> getProjections() {
		return projections;
	}
	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}	
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

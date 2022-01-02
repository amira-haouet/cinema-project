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

import org.sid.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	ICinemaInitService	filmService ;

	@RequestMapping(method = RequestMethod.GET)
	public List<Film> getAllMedecin() {
		return filmService.getAllMedecin();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Film getMedecinById(@PathVariable("id") Long id) {
		return filmService.getMedecin(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteMedecinById(@PathVariable("id") Long id) {
		filmService.deleteMedecinById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Film updateMedecin(@RequestBody Film m) {
		return filmService.updateMedecin(m);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Film saveMedecin(@RequestBody Film m) {
		return filmService.saveMedecin(m);
	}

	@GetMapping("/page")
	public Page<Film> showPage(@RequestParam(name = "p", defaultValue = "0") int page) {
		Page<Film> p = filmService.getAllmedecinPage(page, 3);
		return p;
	}

	@RequestMapping(value = "/findSpec/{s}", method = RequestMethod.GET)
	public List<Film> getBySpecialite(@PathVariable("s") String s) {
		System.out.println(s);
		return filmService.findMedecinBySpecialite(s);
	}

}

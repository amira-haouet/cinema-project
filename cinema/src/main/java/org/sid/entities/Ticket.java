package org.sid.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomClient;
	private double prix;
	@Column(unique = false, nullable = true)
	private Integer codePaiement;
	private boolean reservee;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;
	public Ticket(Long id, String nomClient, double prix, Integer codePaiement, boolean reservee, Place place,
			Projection projection) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.prix = prix;
		this.codePaiement = codePaiement;
		this.reservee = reservee;
		this.place = place;
		this.projection = projection;
	}
	public Ticket() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Integer getCodePaiement() {
		return codePaiement;
	}
	public void setCodePaiement(Integer codePaiement) {
		this.codePaiement = codePaiement;
	}
	public boolean isReservee() {
		return reservee;
	}
	public void setReservee(boolean reservee) {
		this.reservee = reservee;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public Projection getProjection() {
		return projection;
	}
	public void setProjection(Projection projection) {
		this.projection = projection;
	}
	
	
}

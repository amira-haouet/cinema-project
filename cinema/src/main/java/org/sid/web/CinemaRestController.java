package org.sid.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.sid.dao.FilmRepository;
import org.sid.dao.TicketRepository;
import org.sid.entities.Film;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
	/*
	 * @Autowired private FilmRepository filmRepository;
	 * 
	 * @GetMapping("/listFilms") public List<Film> films(){ return
	 * filmRepository.findAll(); }
	 */
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name = "id") Long id) throws Exception {

		Film f = filmRepository.findById(id).get();
		String photoName = f.getPhoto();
		File file = new File(System.getProperty("user.home") + "/cinema/images/" + photoName);
		System.out.println(file);
		// File file=new File(System.getProperty("D:/images/"+photoName));
		Path path = Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}

	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm) {
		List<Ticket> listTickets = new ArrayList<>();
		ticketForm.getTickets().forEach(idTicket -> {
			//System.out.println(idTicket);
			Ticket ticket = ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReservee(true);
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		return listTickets;

	}

	@Data
	static class TicketForm {
		private String nomClient;
		private List<Long> tickets = new ArrayList<>();
		public TicketForm(String nomClient, List<Long> tickets) {
			super();
			this.nomClient = nomClient;
			this.tickets = tickets;
		}
		public TicketForm() {
			super();
		}
		public String getNomClient() {
			return nomClient;
		}
		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}
		public List<Long> getTickets() {
			return tickets;
		}
		public void setTickets(List<Long> tickets) {
			this.tickets = tickets;
		}
		
		
	}
}

package fr.esic.solutec.rest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.solutec.entities.Event;
import fr.esic.solutec.repositories.EventRepository;

@RestController
@CrossOrigin("*")
public class EventRest {

	@Autowired
	private EventRepository eventRepo;

	// Un user peut rajouter des évènements
	@PostMapping("event")
	public Event addEvent(@RequestBody Event e) {
		return eventRepo.save(e);
	}

	// Un user peut voir les évent a venir
	@GetMapping("event/after")
	public List<Event> futurEvent() {
		return eventRepo.findByDateEventAfter(Date.valueOf(LocalDate.now()));
	}

	// Un user peut voir les event passé
	@GetMapping("event/before")
	public List<Event> beforeEvent() {
		return eventRepo.findByDateEventBefore(Date.valueOf(LocalDate.now()));
	}

	@GetMapping("event")
	public Iterable<Event> getAllEvent() {
		return eventRepo.findAll();
	}

}

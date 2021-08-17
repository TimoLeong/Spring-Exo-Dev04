package fr.esic.solutec.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.esic.solutec.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	public List<Event> findByDateEventAfter(Date date);
	
	public List<Event> findByDateEventBefore(Date date);
}

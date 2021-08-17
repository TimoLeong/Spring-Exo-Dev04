package fr.esic.solutec.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Event {

	@Id @GeneratedValue
	private Long id;
	private String titre;
	private String description;
	private Date dateEvent;
	
}

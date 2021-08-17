package fr.esic.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@NoArgsConstructor @AllArgsConstructor @Data 
public class User {
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull private String login;
	@NonNull private String password;
	private String nom;
	private String prenom;
	
}

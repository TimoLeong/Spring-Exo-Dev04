package fr.esic.solutec.entities;

//import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data

public class Memo {
	
	@Id @GeneratedValue
	private Long id;
	
	private String text;
	
	@CreationTimestamp
	private Timestamp dateCreation;
	
	@ManyToOne
	private User user;
	
	@Value("${publicMemo:false}")
	private boolean publicMemo;
}

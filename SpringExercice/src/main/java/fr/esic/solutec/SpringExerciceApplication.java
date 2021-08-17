package fr.esic.solutec;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.solutec.entities.Event;
import fr.esic.solutec.entities.Memo;
import fr.esic.solutec.entities.User;
import fr.esic.solutec.repositories.EventRepository;
import fr.esic.solutec.repositories.MemoRepository;
import fr.esic.solutec.repositories.UserRepository;

@SpringBootApplication
public class SpringExerciceApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MemoRepository memoRepo;
	
	@Autowired
	EventRepository eventRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringExerciceApplication.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Début instruction perso");
		
		userRepo.save(new User(null, "test", "123", "Hirasawa", "Yui"));
		userRepo.save(new User(null, "login", "azerty", "Kevin", "Jean"));
		userRepo.save(new User(null, "light", "qwerty", "Kagura", "Hikari"));
		
		memoRepo.save(new Memo(null, "Je vais faire les courses", null, userRepo.findById((long) 1).get(), userRepo.findById((long) 3).get(), false));
		memoRepo.save(new Memo(null, "Je suis chez moi", null, userRepo.findById((long) 1).get(), userRepo.findById((long) 2).get(), false));
		memoRepo.save(new Memo(null, "Acheter des pommes", null, userRepo.findById((long) 1).get(), null, false));
		memoRepo.save(new Memo(null, "Y'a projet les gars", null, userRepo.findById((long) 1).get(), null, true));
		
		eventRepo.save(new Event(null, "Fête", "Ca va être le fun", Date.valueOf("2021-05-06")));
		eventRepo.save(new Event(null, "Afterwork", "Boire pour oublier", Date.valueOf("2021-08-27")));
		eventRepo.save(new Event(null, "Endwalker", "Le début de la fin", Date.valueOf("2021-11-23")));
		eventRepo.save(new Event(null, "Début Formation", "informatique", Date.valueOf("2021-07-19")));
	}
	
	

}

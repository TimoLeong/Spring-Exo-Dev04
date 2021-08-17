package fr.esic.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.solutec.entities.User;
import fr.esic.solutec.repositories.UserRepository;

@SpringBootApplication
public class SpringExerciceApplication implements CommandLineRunner{

	@Autowired
	UserRepository UserRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringExerciceApplication.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Début instruction perso");
		
		UserRepo.save(new User(null, "test", "123", "Hirasawa", "Yui"));
		UserRepo.save(new User(null, "login", "azerty", "Kevin", "Jean"));
		
	}
	
	

}

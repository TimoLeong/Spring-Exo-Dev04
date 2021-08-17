package fr.esic.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.solutec.entities.User;
import fr.esic.solutec.repositories.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {

	@Autowired
	private UserRepository UserRepo;
	
	// Un user peut se connecter avec un login et un mot de passe.
	@PostMapping("login")
	public User verifyLogin(@RequestBody User u){
		return UserRepo.findByLoginAndPassword(u.getLogin(), u.getPassword());
	}
	
}

package fr.esic.solutec.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.esic.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByLoginAndPassword(String login, String password);
}

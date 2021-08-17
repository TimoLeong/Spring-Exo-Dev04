package fr.esic.solutec.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.esic.solutec.entities.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
	
	public List<Memo> findBySenderId(Long id);
	
	public List<Memo> findByReceiverId(Long id);
	
}

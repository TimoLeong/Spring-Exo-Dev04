package fr.esic.solutec.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.esic.solutec.entities.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
	
	public List<Memo> findByUserId(Long id);
	
}

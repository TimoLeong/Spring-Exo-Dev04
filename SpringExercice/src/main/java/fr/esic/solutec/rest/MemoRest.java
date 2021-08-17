package fr.esic.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.solutec.entities.Memo;
import fr.esic.solutec.repositories.MemoRepository;

@RestController @CrossOrigin("*")
public class MemoRest {
	
	@Autowired
	private MemoRepository memoRepo;
	
	
	// Un user peut voir ses notes rapides (style memo). (/memo/user/{idUser}): get
	@GetMapping("memo/user/{idUser}")
	public List<Memo> getUserMemo(@PathVariable Long idUser){
		return memoRepo.findBySenderId(idUser);
	}
	
	// Un user peut laisser une note a l'attention d'un autre utilisateur
	@PostMapping("memo")
	public Memo addMemo(@RequestBody Memo m) {
		return memoRepo.save(m);
	}
	
	// api qui affiche tous les memos pour tests
	@GetMapping("memo")
	public Iterable<Memo> getAllMemo(){
		return memoRepo.findAll();
	}
	
	// Mettre un memo public ou privé
	@PutMapping("memo/{id}")
	public boolean changeMemoPrivacy(@RequestBody boolean publicMemo, @PathVariable Long id) {
		Optional<Memo> m = memoRepo.findById(id);
		if (m.isPresent()) {
			m.get().setPublicMemo(publicMemo);
			memoRepo.save(m.get());
			return true;
		} else
			return false;
	}
	
	// Récupérer les mémos reçus
	@GetMapping("memo/received/{id}")
	public List<Memo> getReceivedMemo(@PathVariable Long id) {
		return memoRepo.findByReceiverId(id);
	}
}

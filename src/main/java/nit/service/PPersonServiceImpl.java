package nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nit.model.BBuch;
import nit.model.PPerson;

@Component("PPersonService")
@Transactional	// Spring provides a transaction manager specifically for JPA.
public class PPersonServiceImpl implements PPersonService {
	
	private PPersonRepository repo;

	@Autowired
	public PPersonServiceImpl(PPersonRepository repo)
	{
		this.repo = repo;
	}
	
	@Override
	public List<PPerson> findByNameLike(String name) {
		return repo.findByNameLike(name);
	}
	
	@Override
	public List<PPerson> findByBesitzer(BBuch buch) {
		return buch.getPPersons();
	}

	@Override
	public PPerson findOne(int id) {
		return repo.findOne(id);
	}

	@Override
	public PPerson save(PPerson b) {
		return repo.save(b);
	}

	@Override
	public void delete(int id) {
		repo.delete(id);
	}

	@Override
	public long length() {
		return repo.count();
	}
}

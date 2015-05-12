package nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nit.model.BBuch;
import nit.model.PPerson;

@Component("bBuchService")
@Transactional	// Spring provides a transaction manager specifically for JPA.
public class BBuchServiceImpl implements BBuchService {
	
	private BBuchRepository repo;

	@Autowired
	public BBuchServiceImpl(BBuchRepository repo)
	{
		this.repo = repo;
	}
	
	@Override
	public List<BBuch> findByNameLike(String name) {
		return repo.findByNameLike(name);
	}

	@Override
	public List<BBuch> findByPerson(PPerson p) {
		return repo.findByPerson(p);
	}
	
	@Override
	public List<BBuch> findByBesitzer(PPerson p) {
		return p.getBBuches2();
	}
	
	@Override
	public BBuch findOne(int id) {
		return repo.findOne(id);
	}

	@Override
	public BBuch save(BBuch b) {
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

package nit.service;

import java.util.List;

import nit.model.BBuch;
import nit.model.PPerson;

public interface PPersonService {
	List<PPerson> findByNameLike(String name);
	List<PPerson> findByBesitzer(BBuch buch);
	PPerson findOne(int id);
	PPerson save(PPerson b);
	void delete(int id);
	long length();
}

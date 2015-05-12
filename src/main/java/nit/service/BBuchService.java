package nit.service;

import java.util.List;

import nit.model.BBuch;
import nit.model.PPerson;

public interface BBuchService {
	List<BBuch> findByNameLike(String name);
	List<BBuch> findByPerson(PPerson p);
	List<BBuch> findByBesitzer(PPerson p);
	BBuch findOne(int id);
	BBuch save(BBuch b);
	void delete(int id);
	long length();
}

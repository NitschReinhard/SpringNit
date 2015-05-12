package nit.service;

import java.util.List;

import nit.model.BBuch;
import nit.model.PPerson;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BBuchRepository extends CrudRepository<BBuch, Integer> {
	@Query ("select b from BBuch b where b.bName like :name")
	List<BBuch> findByNameLike(@Param("name") String name);
	@Query ("select b from BBuch b where b.PPerson like :person")
	List<BBuch> findByPerson(@Param("person") PPerson person);
}

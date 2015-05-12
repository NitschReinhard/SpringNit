package nit.service;

import java.util.List;

import nit.model.PPerson;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PPersonRepository extends CrudRepository<PPerson, Integer> {
	@Query ("select p from PPerson p where p.pName like :name")
	List<PPerson> findByNameLike(@Param("name") String name);
}

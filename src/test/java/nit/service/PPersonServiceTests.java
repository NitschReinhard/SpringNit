package nit.service;

import static org.junit.Assert.*;

import java.util.List;

import nit.Config;
import nit.model.BBuch;
import nit.model.PPerson;
import nit.model.PPerson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class PPersonServiceTests {

	@Autowired
	private BBuchService buecher;
	@Autowired
	private PPersonService personen;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findOneTest() {
		PPerson p = personen.findOne(1);
		assertTrue(p.getPName().compareTo("Preissl") == 0);
	}
	@Test
	public void findLikeTest() {
		List<PPerson> p = personen.findByNameLike("Pr%");
		assertTrue(p.size() == 1);
		assertTrue(p.get(0).getPName().compareTo("Preissl") == 0);
	}
	
	@Test //Many-to-Many
	public void findByBesitzerTest() {
		BBuch b = buecher.findOne(1);
		List<PPerson> p = personen.findByBesitzer(b);
		assertTrue(p.size() == 2);
		assertTrue(p.get(0).getPName().compareTo("Preissl") == 0);
		assertTrue(p.get(1).getPName().compareTo("Tschernko") == 0);
	}
}

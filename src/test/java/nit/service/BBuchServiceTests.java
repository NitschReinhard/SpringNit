package nit.service;

import static org.junit.Assert.*;

import java.util.List;

import nit.Config;
import nit.model.BBuch;
import nit.model.PPerson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class BBuchServiceTests {

	@Autowired
	private BBuchService buecher;
	@Autowired
	private PPersonService personen;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findOneTest() {
		BBuch b = buecher.findOne(1);
		assertTrue(b.getBName().compareTo("C# For Dummies") == 0);
	}
	@Test
	public void findLikeTest() {
		List<BBuch> b = buecher.findByNameLike("C#%");
		assertTrue(b.size() == 1);
		assertTrue(b.get(0).getBName().compareTo("C# For Dummies") == 0);
	}
	
	@Test //One-to-Many
	public void findByPersonTest() {
		PPerson p = personen.findOne(1);
		List<BBuch> b = buecher.findByPerson(p);
		assertTrue(b.size() == 2);
		assertTrue(b.get(0).getBName().compareTo("C# For Dummies") == 0);
		assertTrue(b.get(1).getBName().compareTo("Tschernko The Best") == 0);
	}
	@Test //Many-to-Many
	public void findByPersonenTest() {
		PPerson p = personen.findOne(1);
		List<BBuch> b = buecher.findByBesitzer(p);
		assertTrue(b.size() == 1);
		assertTrue(b.get(0).getBName().compareTo("C# For Dummies") == 0);
	}
}

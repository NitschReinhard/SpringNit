package nit;

import java.util.List;

import nit.model.BBuch;
import nit.service.BBuchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@Import(Config.class)
@SpringBootApplication
public class SpringNitApplication implements CommandLineRunner {

	@Autowired
	private BBuchService buecher;
	
	public static void main(String[] args) {
        SpringApplication.run(SpringNitApplication.class, args);
    }

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		testRead();
	}
	
	
	
	private void testRead() {
		List<BBuch> l = buecher.findByNameLike("C# For Dummies");
		System.out.println(l.get(0));
	}
}

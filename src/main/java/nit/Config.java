package nit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@Configuration ... tells Spring to treat this as a configuration class and register it as a Bean
//@ComponentScan ... we define the package to load the classes from
//@EnableAutoConfiguration ... tells Spring to treat this class as a consumer of application.yml/properties values

@SpringBootApplication 			// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableTransactionManagement 	// Activate processing of Spring's @Transactional annotation

//Annotation to enable JPA repositories:
//Will scan the package of the annotated configuration class for Spring Data repositories by default.
@EnableJpaRepositories  
public class Config {

}

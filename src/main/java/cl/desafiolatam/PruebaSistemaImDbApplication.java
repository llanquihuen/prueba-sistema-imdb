package cl.desafiolatam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PruebaSistemaImDbApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PruebaSistemaImDbApplication.class, args);
		
//	AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
//	UserRepository ur = acac.getBean(UserRepository.class);
//	
//	System.out.println(ur.findAll().get(0).getUsername());
	}

}

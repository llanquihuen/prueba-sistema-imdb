package cl.desafiolatam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PruebaSistemaImDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSistemaImDbApplication.class, args);
		
//	AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
//	UserRepository ur = acac.getBean(UserRepository.class);
//	
//	System.out.println(ur.findAll().get(0).getUsername());
	}

}

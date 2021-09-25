package cl.desafiolatam;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
//@ComponentScan("cl.desafiolatam")
//@PropertySource("classpath:database.properties")
//public class AppConfig {
////	@Autowired	
////	Environment environment;
////	
////	@Bean
////	DataSource dataSource() {
////		DriverManagerDataSource driverManager = new DriverManagerDataSource();
////		driverManager.setUrl(environment.getProperty("url"));
////		driverManager.setUsername(environment.getProperty("dbuser"));
////		driverManager.setPassword(environment.getProperty("dbpassword"));
////		driverManager.setDriverClassName(environment.getProperty("driver"));
////		return driverManager;
////	}
//}
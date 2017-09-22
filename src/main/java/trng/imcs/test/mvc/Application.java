package trng.imcs.test.mvc;

import java.sql.Date;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import trng.imcs.test.mvc.service.PassengerServiceImpl;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class Application extends SpringBootServletInitializer{
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);	
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context =SpringApplication.run(Application.class, args);
		PassengerServiceImpl impl = context.getBean(PassengerServiceImpl.class);
		System.out.println(impl.getPassenger(1));
		
		
	}
    
    


}

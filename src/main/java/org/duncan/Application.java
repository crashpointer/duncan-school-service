package org.duncan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author crash pointer
 * <p>This class is the main application layer.</p>
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * <p>It is main method of the project. Firstly, That method is executed.</p>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}

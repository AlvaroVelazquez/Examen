package es.salesianos.ExamenMio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "es.salesianos.*" })
@SpringBootApplication
public class ExamenMioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenMioApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExamenMioApplication.class);
	}
}

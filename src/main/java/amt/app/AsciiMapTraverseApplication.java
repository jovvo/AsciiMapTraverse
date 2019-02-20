package amt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("amt")
@Configuration
public class AsciiMapTraverseApplication {
	
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(AsciiMapTraverseApplication.class);
	}

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(AsciiMapTraverseApplication.class, args);
	}
}

package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@SpringBootConfiguration
@ImportResource({"sajat-servlet.xml", "sajat-security.xml"})
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}
	
}

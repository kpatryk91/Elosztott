package hu.iit.uni.miskolc.elosztott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@Configuration
public class KezdospringApplication {

	public static void main(String[] args) {
		ApplicationContext context =
			    //new ClassPathXmlApplicationContext(new String[] {"data.xml"});
		new AnnotationConfigApplicationContext(KezdospringApplication.class);
		//SpringApplication.run(KezdospringApplication.class, args);
		
		A a = (A) context.getBean(A.class);
		a.hello();

	}

	@Bean
	public A getA(B b) {
		return new A(b);
	}
	
	@Bean
	public B getB() {
		return new BImpl();
	}
}

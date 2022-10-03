package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		
		Hello hello = new Hello();
		hello.setData("hello");
		String data = hello.getData();
		System.out.println(data);
		SpringApplication.run(JpashopApplication.class, args);
	}
	
	@Bean
	Hibernate5Module hibernate5Module() {
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		//hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
		return hibernate5Module;
	}
	
	
}
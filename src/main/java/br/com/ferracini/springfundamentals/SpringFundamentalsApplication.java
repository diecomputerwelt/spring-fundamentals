package br.com.ferracini.springfundamentals;

import br.com.ferracini.service.SpeakerService;
import br.com.ferracini.service.SpeakerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringFundamentalsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);

		System.out.println(service.findAll());

		//SpringApplication.run(SpringFundamentalsApplication.class, args);
	}

}

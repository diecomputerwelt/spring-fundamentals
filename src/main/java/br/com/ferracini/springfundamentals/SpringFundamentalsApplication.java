package br.com.ferracini.springfundamentals;

import br.com.ferracini.service.SpeakerService;
import br.com.ferracini.service.SpeakerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFundamentalsApplication.class, args);
		SpeakerService service = new SpeakerServiceImpl();
		System.out.println(service.findAll());
	}

}

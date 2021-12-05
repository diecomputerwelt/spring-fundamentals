package br.com.ferracini.springfundamentals;

import br.com.ferracini.config.AppConfig;
import br.com.ferracini.service.SpeakerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class SpringFundamentalsApplication {
    static Logger logger = LoggerFactory.getLogger(SpringFundamentalsApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);
        logger.info(String.valueOf(service));
        logger.info(String.valueOf(service.findAll()));

        SpeakerService service2 = applicationContext.getBean("speakerService", SpeakerService.class);
        logger.info(String.valueOf(service2));
    }

}

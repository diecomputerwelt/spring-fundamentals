package br.com.ferracini.springfundamentals;

import br.com.ferracini.service.SpeakerService;
import br.com.ferracini.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        return new SpeakerServiceImpl();
    }
}

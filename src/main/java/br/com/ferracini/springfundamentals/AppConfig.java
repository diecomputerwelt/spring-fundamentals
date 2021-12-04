package br.com.ferracini.springfundamentals;

import br.com.ferracini.repository.HibernateSpeakRepositoryImpl;
import br.com.ferracini.repository.SpeakRepository;
import br.com.ferracini.service.SpeakerService;
import br.com.ferracini.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakRepository getSpeakerRepository() {
        return new HibernateSpeakRepositoryImpl();
    }
}

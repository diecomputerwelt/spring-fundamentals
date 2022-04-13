package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}

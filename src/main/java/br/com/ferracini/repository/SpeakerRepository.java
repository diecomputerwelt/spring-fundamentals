package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    List<Speaker> findAll();
}

package br.com.ferracini.repository;

import br.com.ferracini.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SessionRepository extends JpaRepository<Session, Long> {
}

package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;

import java.util.List;

public interface SpeakRepository {
    List<Speaker> findAll();
}

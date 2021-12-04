package br.com.ferracini.service;

import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.HibernateSpeakRepositoryImpl;
import br.com.ferracini.repository.SpeakRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakRepository repository;

    public SpeakerServiceImpl(SpeakRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }

    public void setRepository(SpeakRepository repository) {
        this.repository = repository;
    }
}

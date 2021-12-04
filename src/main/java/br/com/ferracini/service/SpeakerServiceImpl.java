package br.com.ferracini.service;

import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.HibernateSpeakRepositoryImpl;
import br.com.ferracini.repository.SpeakRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class SpeakerServiceImpl implements SpeakerService {
    Logger logger = Logger.getLogger(SpeakerServiceImpl.class.getName());
    private SpeakRepository repository;

    public SpeakerServiceImpl() {
        logger.info("SpeakerServiceImpl no args constructor");
    }

    public SpeakerServiceImpl(SpeakRepository repository) {
        logger.info("SpeakerServiceImpl repository constructor");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    @Autowired
    public void setRepository(SpeakRepository repository) {
        logger.info("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}

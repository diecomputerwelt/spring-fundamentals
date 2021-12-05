package br.com.ferracini.service;

import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SpeakRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    Logger logger = LoggerFactory.getLogger(SpeakerServiceImpl.class);

    @Autowired
    private SpeakRepository repository;

    public SpeakerServiceImpl() {
        logger.info("SpeakerServiceImpl no args constructor");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}

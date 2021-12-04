package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakRepositoryImpl implements SpeakRepository {

    public HibernateSpeakRepositoryImpl() {
    }

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakerList = new ArrayList<>();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Laercio");
        speaker.setLastName("Ferracini");
        speakerList.add(speaker);
        return speakerList;
    }
}

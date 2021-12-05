package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakRepositoryImpl implements SpeakRepository {


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

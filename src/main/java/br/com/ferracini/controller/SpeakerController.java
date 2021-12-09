package br.com.ferracini.controller;

import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Speaker get(@PathVariable Long id) {
        var speaker = speakerRepository.findById(id);
        return speaker.orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        //Need to check children records before deleting
        speakerRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        //TODO: Add validation that all attributes are passed id, otherwise return 400 Bad Request
        var existingSpeaker = speakerRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
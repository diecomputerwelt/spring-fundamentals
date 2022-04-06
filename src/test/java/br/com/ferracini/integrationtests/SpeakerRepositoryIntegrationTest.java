package br.com.ferracini.integrationtests;

import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SpeakerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName(value = "Speaker repository integration test")
@DataJpaTest
class SpeakerRepositoryIntegrationTest {

    @Autowired
    private SpeakerRepository subject;

    @AfterEach
    void tearDown() {
        subject.deleteAll();
    }

    @Test
    @DisplayName(value = "should save and fetch speaker")
    void shouldSaveAndFetchSpeaker() {
        var speaker = new Speaker();
        speaker.setFirstName("Freddy");
        speaker.setLastName("Mercury");
        speaker.setCompany("Test company");
        speaker.setTitle("Test title");
        speaker.setSpeakerBio("Test bio");

        var expectedSpeaker = subject.saveAndFlush(speaker);

        assertThat(expectedSpeaker, is(speaker));
        assertEquals(1L, expectedSpeaker.getSpeakerId());
    }
}

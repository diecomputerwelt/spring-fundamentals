package br.com.ferracini.repository;

import br.com.ferracini.model.Speaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(value = "Speaker repository integration test")
class SpeakerRepositoryIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private SpeakerRepository subject;

    @AfterEach
    void tearDown() {
        subject.deleteAll();
    }

    @Test
    @DisplayName(value = "should save and fetch speaker")
    void shouldSaveAndFetchSpeaker() {
        var speaker = new Speaker("Freddy", "Mercury", "Test company", "Test title", "Test bio");

        var expectedSpeaker = subject.saveAndFlush(speaker);

        assertThat(expectedSpeaker, is(speaker));
        assertEquals(1L, expectedSpeaker.getSpeakerId());
    }
}
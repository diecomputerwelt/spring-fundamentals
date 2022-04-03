package br.com.ferracini;

import br.com.ferracini.controller.SpeakerController;
import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SpeakerRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@DisplayName(value = "Speaker controller test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpeakerControllerTest {

    private SpeakerController subject;

    @Mock
    private SpeakerRepository speakerRepository;
    private Speaker speaker;

    @BeforeEach
    void setUp() {
        openMocks(this);
        subject = new SpeakerController(speakerRepository);
        speaker = new Speaker();
        speaker.setSpeakerId(1L);
        speaker.setFirstName("Freddy");
        speaker.setLastName("Mercury");
        speaker.setCompany("Test company");
        speaker.setTitle("Test title");
        speaker.setSpeakerBio("Test bio");
    }

    @Order(1)
    @Test
    @DisplayName("should return an empty list of speakers")
    void emptyListSpeakersTest() {
        given(speakerRepository.findAll()).willReturn(new ArrayList<>());
        var speakerList = subject.list();
        assertThat(speakerList, is(empty()));
    }

    @Order(2)
    @Test
    @DisplayName("should return list of speakers")
    void listSpeakersTest() {
        var speaker2 = getSpeaker();
        var speakers = new ArrayList<Speaker>();
        speakers.add(speaker);
        speakers.add(speaker2);
        given(speakerRepository.findAll()).willReturn(speakers);

        var speakerList = subject.list();

        assertThat(speakerList, contains(speaker, speaker2));
    }

    @Test
    @DisplayName(value = "should return speaker by id")
    void returnSpeakerByIdTest() {

        given(speakerRepository.findById(1L)).willReturn(Optional.of(speaker));

        var expectedSpeaker = subject.get(1L);

        assertThat(expectedSpeaker, is(speaker));
    }

    @Test
    @DisplayName(value = "should create speaker")
    void createSpeaker() {

        given(speakerRepository.saveAndFlush(speaker)).willReturn(speaker);

        var expectedSpeaker = subject.create(speaker);

        assertThat(expectedSpeaker, is(speaker));

    }

    @Test
    @DisplayName(value = "should update speaker")
    void updateSpeakerTest() {
        var id = 1L;
        var speakerUpdated = speaker;
        speakerUpdated.setTitle("Updated title");
        speakerUpdated.setCompany("Updated company");
        speakerUpdated.setSpeakerBio("Updated bio");

        given(speakerRepository.findById(id)).willReturn(Optional.of(speaker));
        given(speakerRepository.saveAndFlush(speakerUpdated)).willReturn(speakerUpdated);

        var expectedSpeakerUpdated = subject.update(id, speaker);

        assertThat(expectedSpeakerUpdated, is(speakerUpdated));
    }

    @Test
    @DisplayName(value = "should delete speaker by id")
    void shouldDeleteSpeakerByIdTest() {
        var id = 1L;
        doNothing().when(speakerRepository).deleteById(id);

        subject.delete(id);

        verify(speakerRepository, times(1)).deleteById(id);

    }

    private Speaker getSpeaker() {
        var speaker = new Speaker();

        speaker.setFirstName("Stein");
        speaker.setLastName(String.valueOf(new Random().nextInt(10000)));
        return speaker;
    }
}
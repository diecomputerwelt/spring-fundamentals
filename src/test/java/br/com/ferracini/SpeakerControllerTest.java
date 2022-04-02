package br.com.ferracini;

import br.com.ferracini.controller.SpeakerController;
import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SpeakerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

@DisplayName(value = "Speaker controller test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpeakerControllerTest {

    private SpeakerController subject;

    @Mock
    private SpeakerRepository speakerRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
        subject = new SpeakerController(speakerRepository);
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
        var speaker1 = getSpeaker();
        var speaker2 = getSpeaker();
        var speakers = new ArrayList<Speaker>();
        speakers.add(speaker1);
        speakers.add(speaker2);
        given(speakerRepository.findAll()).willReturn(speakers);

        var speakerList = subject.list();

        assertThat(speakerList, contains(speaker1, speaker2));
    }

    @Test
    @DisplayName(value = "should return speaker by id")
    void returnSpeakerByIdTest(){
        var speaker = new Speaker();
        speaker.setSpeakerId(1L);
        speaker.setFirstName("Rich");
        speaker.setLastName("Blackmore");
        given(speakerRepository.findById(1L)).willReturn(Optional.of(speaker));

        var expectedSpeaker = subject.get(1L);

        assertThat(expectedSpeaker, is(speaker));
    }
@Test
@DisplayName(value = "should create speaker")
void createSpeaker(){
    var speaker = new Speaker();
    speaker.setFirstName("Freddy");
    speaker.setLastName("Mercury");
    speaker.setCompany("Test company");
    speaker.setTitle("Test title");
    speaker.setSpeakerBio("Test bio");

    given(speakerRepository.saveAndFlush(speaker)).willReturn(speaker);

    var expectedSpeaker = subject.create(speaker);

    assertThat(expectedSpeaker.getSpeakerId(), is(1));

}

    private Speaker getSpeaker() {
        var speaker = new Speaker();

        speaker.setFirstName("Stein");
        speaker.setLastName(String.valueOf(new Random().nextInt(10000)));
        return speaker;
    }
}
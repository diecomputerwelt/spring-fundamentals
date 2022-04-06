package br.com.ferracini.unittests;

import br.com.ferracini.controller.SessionsController;
import br.com.ferracini.model.Session;
import br.com.ferracini.repository.SessionRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@DisplayName(value = "Sessions controller test")
class SessionsControllerTest {

    private SessionsController subject;
    private Session session;
    @Mock
    private SessionRepository sessionRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
        subject = new SessionsController(sessionRepository);
        session = new Session();
        session.setSessionId(1L);
        session.setSessionLength(45);
        session.setSessionName("Keynote - The Golden Age of Software");
        session.setSessionDescription("Test description");
    }

    @Test
    @DisplayName("should return list of sessions")
    void shouldReturnListOfSessionsTest() {
        var sessionList = List.of(session);

        given(sessionRepository.findAll()).willReturn(sessionList);

        var expectedList = subject.list();

        assertThat(expectedList, CoreMatchers.is(sessionList));
    }

    @Test
    @DisplayName("should return an empty list of sessions")
    void shouldReturnAnEmptyListOfSessionsTest() {
        var sessionList = new ArrayList<Session>();

        given(sessionRepository.findAll()).willReturn(sessionList);

        var expectedList = subject.list();

        assertThat(expectedList, Matchers.empty());
    }

    @DisplayName(value = "should return session by id")
    @Test
    void get() {
        var id = 1L;
        given(sessionRepository.findById(id)).willReturn(Optional.of(session));

        var expectedSession = subject.get(id);

        assertThat(expectedSession, Matchers.is(session));
    }

    @DisplayName(value = "should create session")
    @Test
    void create() {
        given(sessionRepository.saveAndFlush(session)).willReturn(session);

        var expectedSession = subject.create(session);

        assertThat(expectedSession, Matchers.is(session));
    }

    @DisplayName(value = "should update session")
    @Test
    void update() {
        var id = 1L;
        var sessionUpdated = session;
        sessionUpdated.setSessionLength(90);
        sessionUpdated.setSessionName("Updated name");
        sessionUpdated.setSessionDescription("Updated description");

        given(sessionRepository.findById(id)).willReturn(Optional.of(session));
        given(sessionRepository.saveAndFlush(sessionUpdated)).willReturn(sessionUpdated);

        var expectedSessionUpdated = subject.update(id, session);

        assertThat(expectedSessionUpdated, is(sessionUpdated));
    }

    @DisplayName(value = "should delete session by id")
    @Test
    void delete() {
        var id = 1L;
        doNothing().when(sessionRepository).deleteById(id);

        subject.delete(id);

        verify(sessionRepository, times(1)).deleteById(id);
    }

}
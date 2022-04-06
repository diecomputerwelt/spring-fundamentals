package br.com.ferracini.integrationtests;

import br.com.ferracini.model.Session;
import br.com.ferracini.model.Speaker;
import br.com.ferracini.repository.SessionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName(value = "Session repository integration test")
@DataJpaTest
class SessionRepositoryIntegrationTest {

    @Autowired
    private SessionRepository subject;

    @AfterEach
    void tearDown() {
        subject.deleteAll();
    }

    @Test
    @DisplayName(value = "should save and fetch session")
    void shouldSaveAndFetchSessionTest() {
        var session = new Session();
        session.setSessionLength(45);
        session.setSessionName("Keynote - The Golden Age of Software");
        session.setSessionDescription("Test description");

        var expectedSession = subject.saveAndFlush(session);

        assertThat(expectedSession, is(session));
        assertEquals(1L, expectedSession.getSessionId());
    }
}

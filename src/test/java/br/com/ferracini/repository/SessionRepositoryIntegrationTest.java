package br.com.ferracini.repository;

import br.com.ferracini.model.Session;
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
class SessionRepositoryIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private SessionRepository subject;

    @AfterEach
    void tearDown() {
        subject.deleteAll();
    }

    @Test
    @DisplayName(value = "should save and fetch session")
    void shouldSaveAndFetchSessionTest() {

        var session = new Session("Keynote - The Golden Age of Software","Test description",45);

        var expectedSession = subject.saveAndFlush(session);

        assertThat(expectedSession, is(session));
        assertEquals(1L, expectedSession.getSessionId());
    }
}

package br.com.ferracini;

import br.com.ferracini.controller.SessionsController;
import br.com.ferracini.controller.SpeakerController;
import br.com.ferracini.model.Session;
import br.com.ferracini.repository.SessionRepository;
import br.com.ferracini.repository.SpeakerRepository;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {SessionsController.class})
class SessionControllerAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionRepository sessionRepository;

    @MockBean
    private SpeakerRepository speakerRepository;

    @Test
    @DisplayName(value = "should return empty session list")
    void shouldReturnEmptySessionListTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/sessions"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    @DisplayName(value = "should return a session list")
    void shouldReturnSessionListTest() throws Exception {

        BDDMockito.given(sessionRepository.findAll()).willReturn(sessionsList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/sessions"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].sessionName",Matchers.is("Keynote - The Golden Age of Software")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].sessionId",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].sessionName",Matchers.is("Property Based Testing")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].sessionId",Matchers.is(2)))
                .andExpect(status().is2xxSuccessful());
    }

    private List<Session> sessionsList() {
        var s1 = new Session("Keynote - The Golden Age of Software", "Test description", 45);
        var s2 = new Session("Property Based Testing", "Test description test", 60);
        return List.of(s1, s2);
    }


}

package br.com.ferracini;

import br.com.ferracini.controller.SessionsController;
import br.com.ferracini.repository.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = SessionsController.class)
class SessionControlerAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionRepository sessionRepository;

    @Test
    void shouldReturnSession() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sessions"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}

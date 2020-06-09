package hr.tvz.bestak.studapp.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LecturerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllLecturers() throws Exception {
        this.mockMvc.perform(get("/lecturer")
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    void getLecturer() throws Exception {
        int TEST_ID = 1,
            TEST_UNVALIDID = -1;

        this.mockMvc.perform(get("/lecturer/{id}", TEST_ID)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/lecturer/{id}", TEST_UNVALIDID)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isNotFound());
    }
}

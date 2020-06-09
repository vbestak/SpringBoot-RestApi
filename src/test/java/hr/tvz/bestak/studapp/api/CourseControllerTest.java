package hr.tvz.bestak.studapp.api;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllCourses() throws Exception {
        this.mockMvc.perform(get("/course")
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    void getCourse() throws Exception {
        final int TEST_ID = 1,
                    TEST_FAKE_ID=-1;
        this.mockMvc.perform(get("/course/{id}", TEST_ID)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/course/{id}", TEST_FAKE_ID)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isNotFound());
    }
}

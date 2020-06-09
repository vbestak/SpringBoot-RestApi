package hr.tvz.bestak.studapp.api;


import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.bestak.studapp.model.StudentCommand;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

import java.time.LocalDate;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void dodatniZad() throws Exception {
        final String INVALID_JMBAG = "0";
        this.mockMvc.perform(get("/student/{jmbag}",INVALID_JMBAG)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isNotFound());
    }

    @Test
    void getStudent() throws Exception {
        final String TEST_GOOD_JMBAG = "9275633956",
                TEST_BAD_JMBAG="0";

        this.mockMvc.perform(get("/student/{jmbag}",TEST_GOOD_JMBAG)
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());


        this.mockMvc.perform(get("/student/{jmbag}",TEST_BAD_JMBAG)
                .with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllStudents() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student").with(user("admin").password("password")
                        .roles("USER", "ADMIN"))
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    void saveStudent() throws Exception {
        final int TEST_ECTS=63;
        final String TEST_JMBAG = "0246011231",
                TEST_FIRST_NAME="Jane",
                TEST_LAST_NAME="Doe",
                TEST_BIRTHDATE="2000-01-01";

        JSONObject json = new JSONObject();
        json.put("firstName", TEST_FIRST_NAME);
        json.put("lastName", TEST_LAST_NAME);
        json.put("dateOfBirth",TEST_BIRTHDATE);
        json.put("jmbag", TEST_JMBAG);
        json.put("numberOfECTS", TEST_ECTS);


        this.mockMvc.perform(post("/student")
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.jmbag").value(TEST_JMBAG))
                .andExpect(jsonPath("$.firstName").value(TEST_FIRST_NAME))
                .andExpect(jsonPath("$.lastName").value(TEST_LAST_NAME));

        this.mockMvc.perform(post("/student")
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @Test
    @DirtiesContext
    void updateStudent() throws Exception {
        final int TEST_ECTS=63;
        final String TEST_JMBAG = "0246011231",
                TEST_FIRST_NAME="Jane",
                TEST_LAST_NAME="Doe",
                TEST_BIRTHDATE="2000-01-01";

        JSONObject json = new JSONObject();
        json.put("firstName", TEST_FIRST_NAME);
        json.put("lastName", TEST_LAST_NAME);
        json.put("dateOfBirth",TEST_BIRTHDATE);
        json.put("jmbag", TEST_JMBAG);
        json.put("numberOfECTS", TEST_ECTS);


        this.mockMvc.perform(put("/student/{jmbag}", TEST_JMBAG)
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    @DirtiesContext
    void delete() throws Exception {
        final String TEST_JMBAG = "0246011299";

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/{jmbag}", TEST_JMBAG)
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                .with(csrf()))
                .andExpect(status().isNoContent());
    }
}

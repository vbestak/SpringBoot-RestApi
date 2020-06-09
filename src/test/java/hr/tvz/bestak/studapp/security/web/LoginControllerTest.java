package hr.tvz.bestak.studapp.security.web;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    private static final String TEST_USERNAME = "admin";
    private static final String TEST_PASSWORD = "pass";

    @Autowired
    private MockMvc mockMvc;

    private LoginController.LoginDTO login;

    @BeforeEach
    void refresh(){
        login = new LoginController.LoginDTO();
        login.setUsername(TEST_USERNAME);
        login.setPassword(TEST_PASSWORD);
    }

    @Test
    void currentUser() throws Exception {
        this.mockMvc.perform(get("/api/user/current-user")
                .with(user("admin").password("password")
                        .roles("ADMIN"))
                .with(csrf()))
                .andExpect(status().isAccepted());

        this.mockMvc.perform(get("/api/user/current-user")
                .with(csrf()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void authenticate() throws Exception {
        JSONObject json = new JSONObject();
        json.put("username", TEST_USERNAME);
        json.put("password", TEST_PASSWORD);

        this.mockMvc.perform(post("/api/authenticate")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        JSONObject badJson = new JSONObject();
        json.put("username", TEST_USERNAME);
        json.put("password", "");

        this.mockMvc.perform(post("/api/authenticate")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(badJson.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}

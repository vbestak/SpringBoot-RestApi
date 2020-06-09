package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void init(){
        user = new User(0, "admin", "admin", "Ivan", "Horvat", Arrays.asList(new Authority(0, "ROLE_ADMIN", new ArrayList<>())));
    }

    @Test
    void getId() {
        assertEquals(0, user.getId());
    }

    @Test
    void setId() {
        int id = 100;
        user.setId(100);
        assertEquals(id, user.getId());
    }

    @Test
    void getUsername() {
        assertEquals("admin", user.getUsername());
    }

    @Test
    void setUsername() {
        String username = "user";
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("admin", user.getPassword());
    }

    @Test
    void setPassword() {
        String password = "pass";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    void getFirstname() {
        assertEquals("Ivan", user.getFirstname());
    }

    @Test
    void setFirstname() {
        String fName = "Iva";
        user.setFirstname(fName);
        assertEquals(fName, user.getFirstname());
    }

    @Test
    void getLastname() {
        assertEquals("Horvat", user.getLastname());
    }

    @Test
    void setLastname() {
        String lName = "Last";
        user.setLastname(lName);
        assertEquals(lName, user.getLastname());
    }

    @Test
    void getAuthorities() {
        assertNotNull(user.getAuthorities());
    }

    @Test
    void setAuthorities() {
        List<Authority> authorities = Arrays.asList(new Authority(0, "ROLE_USER", null));
        user.setAuthorities(authorities);
        assertEquals(authorities, user.getAuthorities());
    }
}

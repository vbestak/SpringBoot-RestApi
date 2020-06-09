package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityTest {
    Authority authority;

    @BeforeEach
    void init(){
        authority = new Authority(0, "ROLE_ADMIN", Arrays.asList(new User(), new User()));
    }

    @Test
    void getId() {
        assertEquals(0, authority.getId());
    }

    @Test
    void setId() {
        int id = 100;
        authority.setId(id);
        assertEquals(id, authority.getId());
    }

    @Test
    void getName() {
        assertEquals("ROLE_ADMIN", authority.getName());
    }

    @Test
    void setName() {
        String test = "ROLE_USER";
        authority.setName(test);
        assertEquals(test, authority.getName());
    }
}

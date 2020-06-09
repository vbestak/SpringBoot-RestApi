package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityDTOTest {

    private static final String TEST_ROLE = "ROLE_ADMIN";
    AuthorityDTO TEST_AUTHORITY;

    @BeforeEach
    void refresh(){
        TEST_AUTHORITY = new AuthorityDTO(TEST_ROLE);
    }

    @Test
    void getRole() {
        assertEquals(TEST_ROLE, TEST_AUTHORITY.getRole());
    }
}

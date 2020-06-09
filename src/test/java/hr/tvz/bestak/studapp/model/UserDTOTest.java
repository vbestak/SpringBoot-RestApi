package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    private static final int TEST_ID = 1;
    private static final String TEST_USERNAME = "user";
    private static final String TEST_FIRSTNAME = "Jane";
    private static final String TEST_LASTNAME = "Doe";
    private static final List<String> TEST_ROLES = Arrays.asList("ROLE_ADMIN");
    UserDTO TEST_USERDTO;

    @BeforeEach
    void refresh(){
        TEST_USERDTO = new UserDTO(TEST_ID, TEST_USERNAME, TEST_FIRSTNAME, TEST_LASTNAME, TEST_ROLES);
    }

    @Test
    void getUsername() {
        assertEquals(TEST_USERNAME, TEST_USERDTO.getUsername());
    }

    @Test
    void getId() {
        assertEquals(TEST_ID, TEST_USERDTO.getId());
    }

    @Test
    void getFirstname() {
        assertEquals(TEST_FIRSTNAME, TEST_USERDTO.getFirstname());
    }

    @Test
    void getLastname() {
        assertEquals(TEST_LASTNAME, TEST_USERDTO.getLastname());
    }

    @Test
    void getAuthorities() {
    assertEquals(TEST_ROLES, TEST_USERDTO.getAuthorities());
    }
}

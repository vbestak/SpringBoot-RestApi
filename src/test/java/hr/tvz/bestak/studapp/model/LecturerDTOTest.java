package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LecturerDTOTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Jane";
    private static final String TEST_LASTNAME = "Doe";
    private static final String TEST_PHONE = "024607412";
    private LecturerDTO TEST_LECTURER;

    @BeforeEach
    void refresh(){
        TEST_LECTURER = new LecturerDTO(TEST_ID, TEST_NAME, TEST_LASTNAME, TEST_PHONE);
    }

    @Test
    void getId() {
        int id = TEST_LECTURER.getId();
        assertEquals(TEST_ID, id);
    }

    @Test
    void getName() {
        String name = TEST_LECTURER.getName();
        assertEquals(TEST_NAME, name);
    }

    @Test
    void getLastName() {
        String lastName = TEST_LECTURER.getLastName();
        assertEquals(TEST_LASTNAME, lastName);
    }

    @Test
    void getPhoneNumber() {
        String phoneNumber = TEST_LECTURER.getPhoneNumber();
        assertEquals(TEST_PHONE, phoneNumber);
    }
}

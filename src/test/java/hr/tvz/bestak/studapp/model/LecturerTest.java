package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LecturerTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Jane";
    private static final String TEST_LASTNAME = "Doe";
    private static final String TEST_PHONE = "0246077412";
    Lecturer TEST_LECTURER;

    @BeforeEach
    void refresh(){
        TEST_LECTURER = new Lecturer(TEST_ID, TEST_NAME, TEST_LASTNAME, TEST_PHONE);
    }

    @Test
    void getId() {
        int id = TEST_LECTURER.getId();
        assertEquals(TEST_ID, id);
    }

    @Test
    void setId() {
        int newId = 5;
        TEST_LECTURER.setId(newId);
        assertEquals(newId, TEST_LECTURER.getId());
    }

    @Test
    void getName() {
        String name = TEST_LECTURER.getName();
        assertEquals(TEST_NAME, name);
    }

    @Test
    void setName() {
        String newName = "John";
        TEST_LECTURER.setName(newName);
        assertEquals(newName, TEST_LECTURER.getName());
    }

    @Test
    void getLastName() {
        String lastname = TEST_LECTURER.getLastName();
        assertEquals(TEST_LASTNAME, lastname);
    }

    @Test
    void setLastName() {
        String newLastName = "ivic";
        TEST_LECTURER.setLastName(newLastName);
        assertEquals(newLastName, TEST_LECTURER.getLastName());
    }

    @Test
    void getPhoneNumber() {
        String phoneNumber = TEST_LECTURER.getPhoneNumber();
        assertEquals(TEST_PHONE, phoneNumber);
    }

    @Test
    void setPhoneNumber() {
        String nPhoneNumber = "01010101010";
        TEST_LECTURER.setPhoneNumber(nPhoneNumber);
        assertEquals(nPhoneNumber, TEST_LECTURER.getPhoneNumber());
    }
}

package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentCommandTest {

    private static final Integer TEST_ID = 1;
    private static final Integer TEST_ECTS = 12;
    private static final String TEST_FIRSTNAME = "John";
    private static final String TEST_LASTNAME = "Doe";
    private static final String TEST_JMBAG = "9999999999";
    private static final String TEST_BIRTHDATE = "2000-01-01";


    StudentCommand TEST_STUDENT;

    @BeforeEach
    void init(){
        TEST_STUDENT = new StudentCommand(TEST_FIRSTNAME, TEST_LASTNAME, TEST_JMBAG, TEST_BIRTHDATE, TEST_ECTS);
        TEST_STUDENT.setId(TEST_ID);
    }

    @Test
    void getName() {
        String name = TEST_STUDENT.getName();

        assertEquals(TEST_FIRSTNAME, name);
    }

    @Test
    void getId() {
        int id = TEST_STUDENT.getId();
        assertEquals(TEST_ID, id);
    }

    @Test
    void setId() {
        int newId = 10;
        TEST_STUDENT.setId(newId);
        assertEquals(newId, TEST_STUDENT.getId());
    }

    @Test
    void getLastName() {
        String lastName = TEST_STUDENT.getLastName();
        assertEquals(TEST_LASTNAME, lastName);
    }

    @Test
    void getBirthDate() {
        assertNotNull(TEST_STUDENT.getBirthDate());
    }

    @Test
    void getJMBAG() {
        String jmbag = TEST_STUDENT.getJMBAG();
        assertEquals(TEST_JMBAG, jmbag);
    }

    @Test
    void getECTSCount() {
        int ects = TEST_STUDENT.getECTSCount();
        assertEquals(TEST_ECTS, ects);
    }
}

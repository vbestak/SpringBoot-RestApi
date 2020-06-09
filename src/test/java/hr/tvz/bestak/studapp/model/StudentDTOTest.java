package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDTOTest {

    private static final int TEST_ID = 1;
    private static final String TEST_JMBAG = "9999999999";
    private static final Integer TEST_ECTS = 60;
    private static final List<CourseDTO> TEST_COURSES = Arrays.asList();
    private static final Boolean TEST_TUITION = true;
    private static final String TEST_FIRSTNAME = "Jane";
    private static final String TEST_LASTNAME = "Doe";
    private static final LocalDate TEST_DATEOFBIRTH = LocalDate.now().minusYears(30);
    StudentDTO TEST_STUDENT;

    @BeforeEach
    void refresh(){
        TEST_STUDENT = new StudentDTO(TEST_ID, TEST_JMBAG, TEST_ECTS, TEST_COURSES, TEST_TUITION, TEST_FIRSTNAME, TEST_LASTNAME, TEST_DATEOFBIRTH);
    }

    @Test
    void getJmbag() {
        String jmbag = TEST_STUDENT.getJmbag();
        assertEquals(TEST_JMBAG, jmbag);
    }

    @Test
    void getId() {
        int id = TEST_STUDENT.getId();
        assertEquals(TEST_ID, id);
    }

    @Test
    void getNumberOfECTS() {
        int ects = TEST_STUDENT.getNumberOfECTS();
        assertEquals(TEST_ECTS, ects);
    }

    @Test
    void getTuitionShouldBePaid() {
        boolean tuition = TEST_STUDENT.getTuitionShouldBePaid();
        assertEquals(TEST_TUITION, tuition);
    }

    @Test
    void getFirstName() {
        String name = TEST_STUDENT.getFirstName();
        assertEquals(TEST_FIRSTNAME, name);
    }

    @Test
    void getLastName() {
        String lastName = TEST_STUDENT.getLastName();
        assertEquals(TEST_LASTNAME, lastName);
    }

    @Test
    void getDateOfBirth() {
        LocalDate date = TEST_STUDENT.getDateOfBirth();
        assertEquals(TEST_DATEOFBIRTH, date);
    }

    @Test
    void getCourses() {
        List courses = TEST_STUDENT.getCourses();
        assertEquals(TEST_COURSES, courses);
    }
}

package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDTOTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Matematika";
    private static final Integer TEST_ECTS = 6;
    private static final Course.Semester TEST_SEMESTER = Course.Semester.summer;
    private static final List<StudentDTO> TEST_STUDENTS = Arrays.asList();
    CourseDTO TEST_COURSE;

    @BeforeEach
    void refresh(){
        TEST_COURSE = new CourseDTO(TEST_ID, TEST_NAME, TEST_ECTS, TEST_SEMESTER, TEST_STUDENTS);
    }

    @Test
    void getId() {
        int id = TEST_COURSE.getId();
        assertEquals(TEST_ID, id);
    }

    @Test
    void getName() {
        String name = TEST_COURSE.getName();
        assertEquals(TEST_NAME, TEST_COURSE.getName());
    }

    @Test
    void getECTS() {
        int ects = TEST_COURSE.getECTS();
        assertEquals(TEST_ECTS, ects);
    }

    @Test
    void getStudents() {
        assertNotNull(TEST_COURSE.getStudents());
    }

    @Test
    void getSemester() {
        Course.Semester semester = TEST_COURSE.getSemester();
        assertEquals(TEST_SEMESTER, semester);
    }
}

package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseCommandTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Matematika";
    private static final Integer TEST_ECTS = 6;
    CourseCommand TEST_COURSE;

    @BeforeEach
    void refrest(){
        TEST_COURSE = new CourseCommand(TEST_ID, TEST_NAME, TEST_ECTS);
    }

    @Test
    void getId() {
        assertEquals(TEST_ID, TEST_COURSE.getId());
    }

    @Test
    void getName() {
        assertEquals(TEST_NAME, TEST_COURSE.getName());
    }

    @Test
    void getECTS() {
        assertEquals(TEST_ECTS, TEST_COURSE.getECTS());
    }
}

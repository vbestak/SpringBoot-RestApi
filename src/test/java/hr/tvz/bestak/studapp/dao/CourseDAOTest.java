package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Matematika";
    private static final Integer TEST_ECTS = 1;
    private static final String TEST_SEMESTER = "summer";

    CourseRepository courseRepository;
    Course TEST_COURSE;

    @BeforeEach
    void refresh(){
        courseRepository = new CourseDAO();
        TEST_COURSE = new Course(TEST_ID, TEST_NAME, TEST_ECTS, TEST_SEMESTER);
    }

    @Test
    void findAll() {
        List courses = courseRepository.findAll();
        assertNotNull(courses);
    }

    @Test
    void editCourse() {
        Optional<Course> course = courseRepository.editCourse(TEST_COURSE);
        assertTrue(course.isPresent());

        Optional<Course> fakeCourse = courseRepository.editCourse(new Course());
        assertTrue(fakeCourse.isEmpty());
    }
}

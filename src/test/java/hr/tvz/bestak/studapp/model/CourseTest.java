package hr.tvz.bestak.studapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;

    @BeforeEach
    void init(){
        course = new Course(0, "java", 7, "summer");
    }

    @Test
    void getStudents() {
        assertNotNull(course.getStudents());
    }

    @Test
    void setSemester() {
        String[] semesters = {"winter", "summer"};

        for (String semester : semesters){
            course.setSemester(semesters[0]);
            assertEquals(semesters[0],  course.getSemester().toString());
        }

        course.setSemester("");
        assertNull(course.getSemester());
    }

    @Test
    void getSemester() {
        assertEquals("summer", course.getSemester().toString());
    }

    @Test
    void getId() {
        assertEquals(0, course.getId());
    }

    @Test
    void getName() {
        assertEquals("java", course.getName());
    }

    @Test
    void getECTS() {
        assertEquals(7, course.getECTS());
    }
}

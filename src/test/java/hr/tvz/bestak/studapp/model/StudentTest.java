package hr.tvz.bestak.studapp.model;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    LocalDate birthDate;

    @BeforeEach
    void init() {
        birthDate = LocalDate.now().minusYears(18);
        student = new Student("Ivan", "Horvat", birthDate, "0247077412", 120);
    }


    @Test
    void getCourses() {
        assertNotNull(student.getCourses());
    }

    @Test
    void setCourses() {
        List<Course> course = Arrays.asList(
                new Course(0, "Java",7, "summer"),
                new Course(1, "Napredna Java", 7, "winter"),
                new Course(2, "Java web aplikacije", 7, "winter"));
        student.setCourses(
                course
        );

        assertEquals(course, student.getCourses());
    }

    @Test
    void getName() {
        assertEquals("Ivan", student.getName());
    }

    @Test
    void setName() {
        student.setName("Marko");
        assertEquals("Marko", student.getName());
    }

    @Test
    void getLastName() {
        assertEquals("Horvat", student.getLastName());
    }

    @Test
    void setLastName() {
        student.setLastName("Jak");
        assertEquals("Jak", student.getLastName());
    }

    @Test
    void getBirthDate() {
        assertEquals(birthDate, student.getBirthDate());
    }

    @Test
    void setBirthDate() {
        LocalDate date = LocalDate.now().minusYears(20);
        student.setBirthDate(date);
        assertEquals(date, student.getBirthDate());
    }

    @Test
    void setId() {
        student.setId(1);
        assertEquals(1, student.getId());
    }

    @Test
    void getId() {
        student.setId(5);
        assertEquals(5, student.getId());
    }

    @Test
    void getJMBAG() {
        assertEquals("0247077412", student.getJMBAG());
    }

    @Test
    void setJMBAG() {
        String jmbag = "0246011312";
        student.setJMBAG(jmbag);
        assertEquals(jmbag, student.getJMBAG());
    }

    @Test
    void getECTSCount() {
        assertEquals(120, student.getECTSCount());
    }

    @Test
    void setECTSCount() {
        int ects = 180;
        student.setECTSCount(ects);
        assertEquals(ects, student.getECTSCount());
    }
}

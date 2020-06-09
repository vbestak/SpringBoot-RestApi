package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.CourseJPARepository;
import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.CourseDTO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class CourseServiceImplTest {


    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "Matematika";
    private static final Integer TEST_ECTS = 6;
    private static final String TEST_SEMESTER = "summer";
    static Course expectedCourse;

    CourseServiceImpl courseService;
    CourseJPARepository courseJPARepository;

    @BeforeAll
    static void start(){
        expectedCourse = new Course(TEST_ID, TEST_NAME, TEST_ECTS, TEST_SEMESTER);
    }

    @BeforeEach
    void init(){
        courseJPARepository = EasyMock.createNiceMock(CourseJPARepository.class);
        courseService = new CourseServiceImpl(courseJPARepository);
    }

    @Test
    void findAll() {
        EasyMock.expect(courseJPARepository.findAll()).andReturn(Arrays.asList(expectedCourse, expectedCourse));
        EasyMock.replay(courseJPARepository);
        CourseDTO courseDTO = courseService.findAll().get(0);
        assertNotNull(courseDTO);
        assertEquals(expectedCourse.getId(), courseDTO.getId());
    }

    @Test
    void findCourse() {
        EasyMock.expect(courseJPARepository.findById(TEST_ID)).andReturn(Optional.of(expectedCourse));
        EasyMock.replay(courseJPARepository);
        CourseDTO courseDTO = courseService.findCourse(1);

        assertEquals(TEST_ID, courseDTO.getId());
    }

    @Test
    void findCoursesByStudentJmbag() {
        String TEST_JMBAG = "0246066954";
        EasyMock.expect(courseJPARepository.findByStudents_JMBAG(TEST_JMBAG)).andReturn(Arrays.asList(expectedCourse));
        EasyMock.replay(courseJPARepository);

        List<CourseDTO> course = courseService.findCoursesByStudentJmbag(TEST_JMBAG);
        assertEquals(TEST_ID, course.get(0).getId());
    }

    @Test
    void mapCourseToDTO() {
        Course course = new Course(0, "java", 7, "summer");
        assertNotNull(courseService.mapCourseToDTO(course));
    }
}

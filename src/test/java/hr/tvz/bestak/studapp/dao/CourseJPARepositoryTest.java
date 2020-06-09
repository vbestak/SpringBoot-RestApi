package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CourseJPARepositoryTest {

    @Autowired
    CourseJPARepository courseJPARepository;

    @Test
    void findByStudents_JMBAG() {
        String jmbag = "0246066954";
        List<Course> courses = courseJPARepository.findByStudents_JMBAG(jmbag);
    }


}

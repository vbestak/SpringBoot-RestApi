package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.annotation.SessionScope;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class StudentJPARepositoryTest {

    @Autowired
    StudentJPARepository studentJPARepository;

    @Test
    void findStudentByJMBAGIs() {
        String jmbag = "0246066954";
        Optional<Student> student = studentJPARepository.findStudentByJMBAGIs(jmbag);

        assertEquals(jmbag, student.get().getJMBAG());
    }

    @Test
    void deleteByJMBAG() {
        String jmbag = "0246066954";
        studentJPARepository.deleteByJMBAG(jmbag);
        Optional<Student> student = studentJPARepository.findStudentByJMBAGIs(jmbag);

        if (student.isPresent()) fail("Failed to delete student");

    }

}

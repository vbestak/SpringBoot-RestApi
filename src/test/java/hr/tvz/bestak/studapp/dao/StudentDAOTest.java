package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private static final String TEST_NAME = "Jane";
    private static final String TEST_LASTNAME = "Doe";
    private static final LocalDate TEST_BIRTHDATE = LocalDate.now().minusYears(18);
    private static final String TEST_JMBAG = "00000000000";
    private static final Integer TEST_ECTS = 63;
    Student TEST_STUDENT;

    StudentRepository studentRepository;

    @BeforeEach
    void refresh(){
        studentRepository = new StudentDAO();
        TEST_STUDENT = new Student(TEST_NAME, TEST_LASTNAME, TEST_BIRTHDATE, TEST_JMBAG, TEST_ECTS);
    }

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        assertNotNull(students);
    }

    @Test
    void findStudentByJMBAG() {
        Optional<Student> student;
        studentRepository.saveStudent(TEST_STUDENT);
        student = studentRepository.findStudentByJMBAG(TEST_JMBAG);
        assertTrue(student.isPresent());

        student = studentRepository.findStudentByJMBAG("");
        assertTrue(student.isEmpty());
    }

    @Test
    void getStudentsWithECTSGreaterOrEqualTo() {
        List<Student> students;
        studentRepository.saveStudent(TEST_STUDENT);
        students =  studentRepository.getStudentsWithECTSGreaterOrEqualTo(TEST_ECTS);
        assertNotNull(students);
    }

    @Test
    void saveStudent() {
        studentRepository.saveStudent(TEST_STUDENT);
        assertNotNull(studentRepository.findStudentByJMBAG(TEST_JMBAG));
    }

    @Test
    void deleteStudent() {
        studentRepository.saveStudent(TEST_STUDENT);
        studentRepository.deleteStudent(TEST_JMBAG);
        assertTrue(studentRepository.findStudentByJMBAG(TEST_JMBAG).isEmpty());
    }
}

package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.StudentJPARepository;
import hr.tvz.bestak.studapp.model.Student;
import hr.tvz.bestak.studapp.model.StudentCommand;
import hr.tvz.bestak.studapp.model.StudentDTO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    private static final Integer TEST_ECTSCOUNT = 60;
    private static final String TEST_JMBAG = "9999999999";
    private static final LocalDate TEST_BIRTHDATE = LocalDate.of(2000, 01, 01);
    private static final String TEST_LASTNAME = "Doe";
    private static final String TEST_NAME = "John";

    StudentJPARepository studentJPARepository;
    StudentServiceImpl studentService;

    static Student TEST_STUDENT;



    @BeforeAll
    static void init(){
        TEST_STUDENT = new Student(TEST_NAME, TEST_LASTNAME, TEST_BIRTHDATE, TEST_JMBAG, TEST_ECTSCOUNT);
        TEST_STUDENT.setId(1);
    }

    @BeforeEach
    void setup(){
        studentJPARepository = EasyMock.createNiceMock(StudentJPARepository.class);
        studentService = new StudentServiceImpl(studentJPARepository);
    }

    @Test
    void findAll() {
        EasyMock.expect(studentJPARepository.findAll()).andReturn(Arrays.asList(TEST_STUDENT, TEST_STUDENT));
        EasyMock.replay(studentJPARepository);

        List<StudentDTO> students = studentService.findAll();

        assertNotNull(students);
        assertTrue(students.size() == 2);
    }

    @Test
    void findStudentByJMBAG() {
        EasyMock.expect(studentJPARepository.findStudentByJMBAGIs(TEST_JMBAG)).andReturn(Optional.of(TEST_STUDENT));
        EasyMock.replay(studentJPARepository);

        StudentDTO foundStudent = studentService.findStudentByJMBAG(TEST_JMBAG);

        assertEquals(TEST_JMBAG, foundStudent.getJmbag());
    }

    @Test
    void saveStudent() {
        StudentCommand student = new StudentCommand(TEST_NAME, TEST_LASTNAME, TEST_JMBAG, "2000-01-01", TEST_ECTSCOUNT);

        EasyMock.expect(studentJPARepository.findStudentByJMBAGIs(TEST_JMBAG)).andReturn(Optional.empty());
        EasyMock.expect(studentJPARepository.save(EasyMock.anyObject())).andReturn(TEST_STUDENT);
        EasyMock.replay(studentJPARepository);

        assertNotNull(studentService.saveStudent(student));
    }

    @Test
    void deleteStudent() {
        studentJPARepository.deleteByJMBAG(TEST_JMBAG);
        EasyMock.expectLastCall().once();
        EasyMock.expect(studentJPARepository.findStudentByJMBAGIs(TEST_JMBAG)).andReturn(Optional.empty());
        EasyMock.replay(studentJPARepository);
        studentService.deleteStudent(TEST_JMBAG);

        assertTrue( studentJPARepository.findStudentByJMBAGIs(TEST_JMBAG).isEmpty());
    }

    @Test
    void mapStudentToDTO() {
        StudentDTO studentDTO = studentService.mapStudentToDTO(TEST_STUDENT);
        assertEquals(TEST_JMBAG, studentDTO.getJmbag());
    }

    @Test
    void shouldTuitionBePayed() {
        assertAll(
                ()->assertEquals(studentService.shouldTuitionBePayed(LocalDate.now().minusYears(27)), true),
                ()-> assertEquals(studentService.shouldTuitionBePayed( LocalDate.now().minusYears(18)), false)
        );
    }
}

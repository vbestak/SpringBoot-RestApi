package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);

    List<Student> getStudentsWithECTSGreaterOrEqualTo(Integer ECTS);

    Student saveStudent(Student student);

    void deleteStudent(String JMBAG);
}

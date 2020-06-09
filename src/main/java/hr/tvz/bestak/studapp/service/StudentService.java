package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.model.Student;
import hr.tvz.bestak.studapp.model.StudentCommand;
import hr.tvz.bestak.studapp.model.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findStudentByJMBAG(String JMBAG);

    StudentDTO saveStudent(StudentCommand student);

    void deleteStudent(String JMBAG);

    StudentDTO mapStudentToDTO(Student student);

    void updateStudent(StudentCommand student, String jmbag);

}

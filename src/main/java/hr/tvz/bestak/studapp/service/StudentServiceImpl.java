package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.StudentJPARepository;
import hr.tvz.bestak.studapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;

    private final StudentJPARepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentJPARepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> findAll(){
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    public StudentDTO findStudentByJMBAG(String JMBAG){
        return studentRepository.findStudentByJMBAGIs(JMBAG).stream().map(this::mapStudentToDTO).findAny().orElse(null);
    }

    @Override
    public StudentDTO saveStudent(StudentCommand studentCommand) {
        boolean studentAlreadyExists = this.studentRepository.findStudentByJMBAGIs(studentCommand.getJMBAG()).isPresent();

        if (studentAlreadyExists == false) {
            Student student = mapStudentCommandToStudent(studentCommand);
            Student responseStudent = this.studentRepository.save(student);

            return mapStudentToDTO(responseStudent);
        }

        return null;
    }

    @Override
    public void deleteStudent(String JMBAG) {
        this.studentRepository.deleteByJMBAG(JMBAG);
    }

    public Student mapStudentCommandToStudent(StudentCommand student){
        return new Student(student.getName(), student.getLastName(), student.getBirthDate(), student.getJMBAG(), student.getECTSCount());
    }

    public StudentDTO mapStudentToDTO(final Student student){
        List<CourseDTO> courses = new ArrayList<CourseDTO>();

        return new StudentDTO(
                student.getId(),
                student.getJMBAG(),
                student.getECTSCount(),
                courses,
                shouldTuitionBePayed(student.getBirthDate()),
                student.getName(),
                student.getLastName(),
                student.getBirthDate()
        );
    }

    @Override
    public void updateStudent(StudentCommand student, String jmbag) {
        Optional<Student>  studentFromDb = this.studentRepository.findStudentByJMBAGIs(jmbag);

        if (studentFromDb.isEmpty()) return;

        studentFromDb.get().setJMBAG(student.getJMBAG());
        studentFromDb.get().setName(student.getName());
        studentFromDb.get().setLastName(student.getLastName());
        studentFromDb.get().setBirthDate(student.getBirthDate());
        studentFromDb.get().setECTSCount(student.getECTSCount());
        this.studentRepository.save(studentFromDb.get());
    }


    public static boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

}

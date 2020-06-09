package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Student;
import hr.tvz.bestak.studapp.model.StudentCommand;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository("StudentDAO")
public class StudentDAO implements StudentRepository  {
    List<Student> students = new ArrayList<Student>(
            Arrays.asList(
            new Student("Ivan", "Ivic", LocalDate.now(), "0246077456", 153 ),
            new Student("Josip", "Maric", LocalDate.now(), "0246944865", 90)
    ));

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return students.stream().filter( student -> Objects.equals(student.getJMBAG(), JMBAG)).findAny();
    }

    @Override
    public List<Student> getStudentsWithECTSGreaterOrEqualTo(Integer ECTS) {
        return students.stream().filter(student -> student.getECTSCount() >= ECTS).collect(Collectors.toList());
    }

    @Override
    public Student saveStudent(Student student) {
            students.add(student);
            return student;
    }

    @Override
    public void deleteStudent(String JMBAG) {
        int indexOfStudent = this.students.stream().map(student -> student.getJMBAG()).collect(Collectors.toList()).indexOf(JMBAG);

        if (indexOfStudent >= 0){
            this.students.remove(indexOfStudent);
        }
    }
}

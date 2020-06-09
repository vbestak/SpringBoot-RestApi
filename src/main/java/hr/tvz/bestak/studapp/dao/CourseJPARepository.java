package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseJPARepository extends JpaRepository<Course, Integer> {

    List<Course> findByStudents_JMBAG(String jmbag);

}

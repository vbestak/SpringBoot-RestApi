package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Student;
import hr.tvz.bestak.studapp.model.StudentCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface StudentJPARepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByJMBAGIs(String JMBAG);

    @Transactional
    void deleteByJMBAG(String JMBAG);

}

package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.Lecturer;
import hr.tvz.bestak.studapp.model.LecturerDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("LecturerDAO")
public class LecturerDAO implements LecturerRepository {
    List<Lecturer> lecturer = new ArrayList<Lecturer>(
            Arrays.asList(
                    new Lecturer(0, "Ivan","Horvat", "4646323"),
                    new Lecturer(1, "Ivana", "Horvat", "4646756")
            )
    );

    @Override
    public List<Lecturer> findAll() {
        return lecturer;
    }

    @Override
    public Optional<Lecturer> findLecturer(Integer lecturerId) {
        return lecturer.stream().filter(lecturer -> lecturer.getId().equals(lecturerId)).findAny();
    }

}

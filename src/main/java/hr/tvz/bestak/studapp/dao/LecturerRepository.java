package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Lecturer;
import hr.tvz.bestak.studapp.model.LecturerDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository {

    List<Lecturer> findAll();

    Optional<Lecturer> findLecturer(Integer lecturerId);

}

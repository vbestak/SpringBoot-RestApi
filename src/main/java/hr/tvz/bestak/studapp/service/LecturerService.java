package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.model.LecturerDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;

import java.util.List;

public interface LecturerService {

    List<LecturerDTO> findAll();

    LecturerDTO findLecturer(Integer lecturerId);

}



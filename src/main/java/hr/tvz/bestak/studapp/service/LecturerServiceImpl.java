package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.LecturerRepository;
import hr.tvz.bestak.studapp.model.Lecturer;
import hr.tvz.bestak.studapp.model.LecturerDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("LecturerServiceImpl")
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(@Qualifier("LecturerDAO") LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<LecturerDTO> findAll() {
        return this.lecturerRepository.findAll().stream().map(this::mapLecturerToDTO).collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturer(Integer lecturerId) {
        return this.lecturerRepository.findLecturer(lecturerId).map(this::mapLecturerToDTO).orElse(null);
    }

    private LecturerDTO mapLecturerToDTO(final Lecturer lecturer){
        return new LecturerDTO(lecturer.getId(), lecturer.getName(), lecturer.getLastName(), lecturer.getPhoneNumber());
    }
}

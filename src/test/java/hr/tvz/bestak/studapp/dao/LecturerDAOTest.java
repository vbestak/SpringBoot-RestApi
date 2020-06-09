package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Lecturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LecturerDAOTest {

    private static final Integer TEST_ID = 0;
    private static final Integer TEST_FAKEID = -100;
    LecturerRepository lecturerRepository;

    @BeforeEach
    void refresh(){
        lecturerRepository = new LecturerDAO();
    }

    @Test
    void findAll() {
        List lecturers = lecturerRepository.findAll();
        assertNotNull(lecturers);
    }

    @Test
    void findLecturer() {
        Optional<Lecturer> lecturer = lecturerRepository.findLecturer(TEST_ID);
        assertTrue(lecturer.isPresent());

        lecturer = lecturerRepository.findLecturer(TEST_FAKEID);
        assertTrue(lecturer.isEmpty());
    }
}

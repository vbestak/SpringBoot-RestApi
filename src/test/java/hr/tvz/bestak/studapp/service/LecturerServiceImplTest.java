package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.LecturerDAO;
import hr.tvz.bestak.studapp.dao.LecturerRepository;
import hr.tvz.bestak.studapp.model.Lecturer;
import hr.tvz.bestak.studapp.model.LecturerDTO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LecturerServiceImplTest {

    private static final Integer TEST_ID = 1;
    private static final String TEST_NAME = "John";
    private static final String TEST_LASTNAME = "Doe";
    private static final String TEST_PHONENUMBER = "0246077412";
    private Lecturer TEST_LECTURER;

    private LecturerRepository lecturerRepository;
    private LecturerServiceImpl lecturerService;

    @BeforeEach
    void refresh(){
        lecturerRepository = EasyMock.createNiceMock(LecturerDAO.class);
        lecturerService = new LecturerServiceImpl(lecturerRepository);
        TEST_LECTURER = new Lecturer(TEST_ID, TEST_NAME, TEST_LASTNAME, TEST_PHONENUMBER);
    }

    @Test
    void findAll() {
        EasyMock.expect(lecturerRepository.findAll()).andReturn(Arrays.asList(TEST_LECTURER));
        EasyMock.replay(lecturerRepository);

        List lecturers = lecturerService.findAll();

        assertNotNull(lecturers);
        assertTrue(lecturers.size() == 1);
    }

    @Test
    void findLecturer() {
        EasyMock.expect(lecturerRepository.findLecturer(TEST_ID)).andReturn(Optional.of(TEST_LECTURER));
        EasyMock.replay(lecturerRepository);

        LecturerDTO lecturer = lecturerService.findLecturer(TEST_ID);

        assertEquals(TEST_ID, lecturer.getId());
    }
}

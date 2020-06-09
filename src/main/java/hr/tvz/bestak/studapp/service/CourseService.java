package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.CourseCommand;
import hr.tvz.bestak.studapp.model.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findCourse(Integer id);

    List<CourseDTO> findCoursesByStudentJmbag(String jmbag);

    CourseDTO mapCourseToDTO(final Course course);
}

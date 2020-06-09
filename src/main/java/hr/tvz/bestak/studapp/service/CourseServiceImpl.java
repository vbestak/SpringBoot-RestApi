package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.CourseJPARepository;
import hr.tvz.bestak.studapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private final CourseJPARepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseJPARepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return this.courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findCourse(Integer id) {
        return this.courseRepository.findById(id).map(this::mapCourseToDTO).orElse(null);
    }

    @Override
    public List<CourseDTO> findCoursesByStudentJmbag(String jmbag) {
        return this.courseRepository.findByStudents_JMBAG(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO mapCourseToDTO(final Course course){
        List<StudentDTO> students = new ArrayList<>();

        if(course.getStudents() != null && !course.getStudents().isEmpty())
            students = null;

        return new CourseDTO(course.getId(), course.getName(), course.getECTS(), course.getSemester(), students);
    }

}

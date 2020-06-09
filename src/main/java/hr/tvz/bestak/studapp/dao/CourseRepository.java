package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    List<Course> findAll();

    Optional<Course> editCourse(Course course);

    //Optional<Course> findCourseById(String courseId);

}

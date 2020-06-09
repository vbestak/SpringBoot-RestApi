package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository("CourseDAO")
public class CourseDAO implements CourseRepository {
    List<Course> courses = new ArrayList<Course>(
            Arrays.asList(
              new Course(0, "Java",7, "summer"),
              new Course(1, "Napredna Java", 7, "winter"),
              new Course(2, "Java web aplikacije", 7, "winter")
            )
    );



    @Override
    public List<Course> findAll() {
        return this.courses;
    }

    @Override
    public Optional<Course> editCourse(Course course) {
        int index = this.courses.stream()
                .map((courseElement)-> courseElement.getId())
                .collect(Collectors.toList())
                .indexOf(course.getId());


        if (index >= 0){
            this.courses.remove(index);
            this.courses.add(course);
            return Optional.of(course);
        }

        return Optional.empty();
    }

}

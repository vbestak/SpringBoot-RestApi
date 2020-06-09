package hr.tvz.bestak.studapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

public class CourseDTO {
    private Integer id;
    private String name;
    private Integer ECTS;
    @JsonIgnore
    private List<StudentDTO> students;
    private Course.Semester semester;

    public CourseDTO(Integer id, String name, Integer ECTS, Course.Semester semester, List<StudentDTO> students) {
        this.id = id;
        this.name = name;
        this.ECTS = ECTS;
        this.semester = semester;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getECTS() {
        return ECTS;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public Course.Semester getSemester() {
        return semester;
    }
}

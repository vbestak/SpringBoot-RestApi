package hr.tvz.bestak.studapp.model;

import hr.tvz.bestak.studapp.utility.SemesterAttributeConverter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer ECTS;

    @Convert(converter = SemesterAttributeConverter.class)
    private Semester semester;

    public enum Semester{
        summer,
        winter
    }

    @ManyToMany( fetch = FetchType.EAGER, targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

    public Course(){}

    public Course(Integer id, String name, Integer ECTS, String semester) {
        this.id = id;
        this.name = name;
        this.ECTS = ECTS;
        this.students = new ArrayList<>();
        setSemester(semester);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setSemester(String semester){
        switch (semester){
            case "summer":
                this.semester = Semester.summer;
                break;
            case "winter":
                this.semester = Semester.winter;
                break;
            default:
                this.semester = null;
                return;
        }
    }

    public Semester getSemester() {
        return semester;
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

}

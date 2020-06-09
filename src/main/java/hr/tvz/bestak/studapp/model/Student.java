package hr.tvz.bestak.studapp.model;

import hr.tvz.bestak.studapp.utility.DateAttributeConverter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Student")
public class Student{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthDate")
    @Convert(converter = DateAttributeConverter.class)
    private LocalDate birthDate;

    @Column(name = "JMBAG")
    private String JMBAG;

    @Column(name="ECTSCount")
    private Integer ECTSCount;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name="STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private List<Course> courses;

    public Student(){}

    public Student(String name, String lastName, LocalDate birthDate, String JMBAG, Integer ECTSCount){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.JMBAG = JMBAG;
        this.ECTSCount = ECTSCount;
        this.courses = new ArrayList<Course>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }

    public Integer getECTSCount() {
        return ECTSCount;
    }

    public void setECTSCount(Integer ECTSCount) {
        this.ECTSCount = ECTSCount;
    }
}

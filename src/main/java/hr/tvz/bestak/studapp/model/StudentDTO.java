package hr.tvz.bestak.studapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    private int id;
    private String jmbag;
    private Integer numberOfECTS;
    private Boolean tuitionShouldBePaid;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @JsonIgnore
    private List<CourseDTO> courses;

    public StudentDTO(int id, String jmbag, Integer numberOfECTS, List<CourseDTO> courses, Boolean tuitionShouldBePaid, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.courses = courses;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getJmbag() {
        return jmbag;
    }

    public int getId() {
        return id;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    public Boolean getTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }
}

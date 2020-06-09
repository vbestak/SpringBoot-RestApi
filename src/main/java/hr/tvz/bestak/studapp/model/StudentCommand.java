package hr.tvz.bestak.studapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentCommand {
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static DateTimeFormatter birthDateFormater = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private int id;

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}")
    private String jmbag;

    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull( message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private Integer numberOfECTS;

    public String getName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return dateOfBirth;
    }

    public String getJMBAG() {
        return jmbag;
    }

    public Integer getECTSCount() {
        return numberOfECTS;
    }

    public StudentCommand(@NotBlank(message = "First name must not be empty") String firstName, @NotBlank(message = "Last name must not be empty") String lastName, @NotBlank(message = "JMBAG must not be empty") @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}") String jmbag, String dateOfBirth, @NotNull(message = "Number of ECTS points must be entered") @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer") @Max(message = "Number of ECTS can not be higher than 480", value = 480) Integer numberOfECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.dateOfBirth = LocalDate.parse(dateOfBirth.substring(0, 10), birthDateFormater);
        this.numberOfECTS = numberOfECTS;
    }

}

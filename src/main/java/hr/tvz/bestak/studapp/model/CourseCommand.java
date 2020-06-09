package hr.tvz.bestak.studapp.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class CourseCommand {

    @NotNull(message = "id can not be empty")
    private Integer id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "ECTS can not be empty")
    @PositiveOrZero(message = "ECTS must be a positive integer")
    @Max(message = "ECTS can not be higher than 7", value = 7)
    private Integer ECTS;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getECTS() {
        return ECTS;
    }

    public CourseCommand(Integer id, String name, Integer ECTS) {
        this.id = id;
        this.name = name;
        this.ECTS = ECTS;
    }
}

package hr.tvz.bestak.studapp.utility;

import hr.tvz.bestak.studapp.model.Course;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;

@Converter(autoApply = true)
public class SemesterAttributeConverter  implements AttributeConverter<Course.Semester, String> {

    @Override
    public String convertToDatabaseColumn(Course.Semester semester) {
        return semester.toString();
    }

    @Override
    public Course.Semester convertToEntityAttribute(String s) {
        if (s.equals("summer"))
            return Course.Semester.summer;
        else
            return Course.Semester.winter;
    }
}

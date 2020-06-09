package hr.tvz.bestak.studapp.utility;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

@Converter(autoApply = true)
public class DateAttributeConverter implements AttributeConverter<LocalDate, String> {
    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

    @Override
    public String convertToDatabaseColumn(LocalDate date) {
        return date.format(FORMATTER);
    }

    @Override
    public LocalDate convertToEntityAttribute(String s) {
        return LocalDate.parse(s, FORMATTER);
    }
}

package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.entities.Status;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusToStringConverter extends EntityConverter<Status, String> {

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public String convert(Status source) {
        return source.getStatusName();
    }

}

package by.kanarski.profito.validation.analyze;

import by.kanarski.profito.validation.annotation.GroupEquals;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
public class ValidationAnalyzer {

    public List<FieldError> checkEq(final Object target) {
        final List<FieldError> errorList = new ArrayList<>();
        final  Multimap<String, Field> groupMap = getGroupMap(target);
        for (final String groupLabel : groupMap.keySet()) {
//            final List<Field> fieldList = groupMap.get(groupLabel);
            boolean isEq = true;
//            Object prevValue = ReflectionUtils.getField(fieldList.get(0), target);
//            for (int i = 1; i < fieldList.size() && isEq; i++) {
//                final Field currentField = fieldList.get(i);
//                final Object currentValue = ReflectionUtils.getField(currentField, target);
//                isEq = Objects.equals(currentValue, prevValue);
//                prevValue = currentValue;
//            }
//            if (!isEq) {
//                FieldError fieldError = new FieldError(target.getClass().getSimpleName(), prevValue.toString(),
//                        fieldName, false, null, null, "{something}"!!);
//                errorList.add(fieldError);
//            }
        }
        return errorList;

    }

    private Multimap<String, Field> getGroupMap(final Object target) {
        final Field[] fields = target.getClass().getDeclaredFields();
        final Multimap<String, Field> groupMap = ArrayListMultimap.create();
        for (Field field : fields) {
            if (field.isAnnotationPresent(GroupEquals.class)) {
                GroupEquals groupEquals = field.getAnnotation(GroupEquals.class);
                final String groupLabel = groupEquals.value();
                field.setAccessible(true);
                groupMap.put(groupLabel, field);
            }
        }
        return groupMap;
    }

}

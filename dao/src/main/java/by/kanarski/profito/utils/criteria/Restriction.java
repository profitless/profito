package by.kanarski.profito.utils.criteria;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface Restriction {

    String getPropertyName();

    PropertyValue getValue();

    RestrictionType getRestrictionType();

}

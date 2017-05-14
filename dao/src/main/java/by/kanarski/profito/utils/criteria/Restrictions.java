package by.kanarski.profito.utils.criteria;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class Restrictions {

    public static Restriction eq(String propertyName, String propertyValue) {
        return new SimpleRestriction(propertyName, PropertyValue.newInstance(propertyValue), RestrictionType.EQ);
    }

}

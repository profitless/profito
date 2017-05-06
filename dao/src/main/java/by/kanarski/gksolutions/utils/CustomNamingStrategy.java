package by.kanarski.gksolutions.utils;

import org.hibernate.cfg.ImprovedNamingStrategy;

import java.util.Properties;

public class CustomNamingStrategy extends ImprovedNamingStrategy {

    private static final String PREV_PACKAGE_REGEXP = "\\w+\\.";
    private static final Properties PREFIXES = new Properties() {
        {
            setProperty("catalog", "c");
            setProperty("handbook", "h");
            setProperty("journal", "j");
            setProperty("manyToMany", "nn");
            setProperty("registry", "r");
        }
    };

    @Override
    public String classToTableName(String className) {
        String tableNameInSingularForm = super.classToTableName(className);
        return tableNameInSingularForm;
//        return transform(tableNameInSingularForm, className);
    }

    // TODO: 05.05.2017 Classname is\ already unqalified, и чо делать?
    private String transform(String tableNameInSingularForm, String className) {
        String packageName;
        try {
            packageName = Class.forName(className).getPackage().getName();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String prefixFullName = packageName.replaceAll(PREV_PACKAGE_REGEXP, "");
        String prefixName = PREFIXES.getProperty(prefixFullName);
        return prefixName
                .concat("_")
                .concat(tableNameInSingularForm);
    }
}



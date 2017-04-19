package by.kanarski.gksolutions.utils.threadLocal;

import by.kanarski.gksolutions.constants.SystemSettings;

import java.util.Currency;
import java.util.Locale;

/**
 * Contains current user's preferces as thread local variables
 * @author Dzmitry Kanarski
 * @version 1.0
 * @see ThreadLocalUtil
 */

public class UserPreferences {

    private UserPreferences() {

    }

    public static Locale getLocale() {
        Locale locale = (Locale) ThreadLocalUtil.LOCALE.get(SystemSettings.DEFAULT_LOCALE);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }

    public static void setLocale(Locale locale) {
        ThreadLocalUtil.LOCALE.set(locale);
    }

    public static Locale getRequestedLocale() {
        Locale locale = (Locale) ThreadLocalUtil.REQUESTED_LOCALE.get(getLocale());
        if (locale == null) {
            locale = getLocale();
            if (locale == null) {
                locale = Locale.getDefault();
            }
        }
        return locale;
    }

    public static void setRequestedLocale(Locale locale) {
        ThreadLocalUtil.REQUESTED_LOCALE.set(locale);
    }

    public static Currency getCurrency() {
        Currency currency = (Currency) ThreadLocalUtil.CURRENCY.get(SystemSettings.DEFAULT_CURRENCY);
        return currency;
    }

    public static void setCurrency(Currency currency) {
        ThreadLocalUtil.CURRENCY.set(currency);
    }
}

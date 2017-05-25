package by.kanarski.profito.ebp.events;

import by.kanarski.profito.dto.user.ConfirmationUser;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Getter
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private ConfirmationUser user;
    private Locale locale;
    private String appUrl;

    public OnRegistrationCompleteEvent(final ConfirmationUser user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

}

package by.kanarski.profito.ebp.listeners;

import by.kanarski.profito.dto.user.ConfirmationUser;
import by.kanarski.profito.ebp.events.OnRegistrationCompleteEvent;
import by.kanarski.profito.mailService.IMailSenderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

@Component
public class RegistrationListener {

    private static final String URL_PART = "/users/email/";

    private IMailSenderHelper mailSenderHelper;

    @Autowired
    public RegistrationListener(IMailSenderHelper mailSenderHelper) {
        this.mailSenderHelper = mailSenderHelper;
    }

    @EventListener
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        sendConfirmationMail(event);
    }

    // TODO: 20.05.2017 Возможно причесать немного
    private void sendConfirmationMail(final OnRegistrationCompleteEvent event) {
        final ConfirmationUser user = event.getUser();
        final String confirmationUrl = createConfirmationUrl(event.getAppUrl(), user.getToken());
        final Context context = new Context(event.getLocale());
        context.setVariable("confirmationUrl", confirmationUrl);
        context.setVariable("recipientEmail", user.getEmail());
            mailSenderHelper.sendSimpleMail(user.getEmail(),
                    "Подтверждение", "mail", context);
    }

    private String createConfirmationUrl(final String appUrl, final String verificationToken) {
        return appUrl.concat(URL_PART).concat(verificationToken);
    }

}

package by.kanarski.profito.mailService;

import by.kanarski.profito.wrappers.EmailConfirmationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 05.05.2017 Картиночки в модуле не подкидываются, найти способ сделать это или перенести модуль в WEB
@Component
public class MailService {

    private final String confirmationUrlTemplate = "http://localhost:8085/profito/users/email/";

    private IMailSenderHelper mailSenderHelper;

    @Autowired
    public MailService(IMailSenderHelper mailSenderHelper) {
        this.mailSenderHelper = mailSenderHelper;
    }

    public void sendEmailConfirmation(EmailConfirmationInfo emailConfirmationInfo) {
        String confirmationUrl = createConfirmationUrl(emailConfirmationInfo.getActivationKey());
        Context context = new Context(emailConfirmationInfo.getLocale());
        context.setVariable("confirmationUrl", confirmationUrl);
        context.setVariable("recipientEmail", emailConfirmationInfo.getEmail());
        try {
            mailSenderHelper.sendSimpleMail(emailConfirmationInfo.getEmail(),
                    "Подтверждение", "mail", context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String createConfirmationUrl(String activationKey) {
        return confirmationUrlTemplate.concat(activationKey);
    }

}

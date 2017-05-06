package by.kanarski.gksolutions.mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.util.Locale;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 05.05.2017 Картиночки в модуле не подкидываются, найти способ сделать это или перенести модуль в WEB
@Component
public class MailService {

    private IMailSenderHelper mailSenderHelper;

    @Autowired
    public MailService(IMailSenderHelper mailSenderHelper) {
        this.mailSenderHelper = mailSenderHelper;
    }

    public void sendRegistrationConfirmation(String recipientEmail, String confirmationUrl, Locale locale) {
        Context context = new Context(locale);
        context.setVariable("confirmationUrl", confirmationUrl);
        context.setVariable("recipientEmail", recipientEmail);
        try {
            mailSenderHelper.sendSimpleMail(recipientEmail, "Подтверждение", "mail", context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    private MimeElement getProfitoLogo() {
//        try {
//            byte[] imageBytes = Files.readAllBytes(Paths.get("\\profito\\resources\\profito_logo.jpg"));
//            return new MimeElement("logo", imageBytes, "image/jpg");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}

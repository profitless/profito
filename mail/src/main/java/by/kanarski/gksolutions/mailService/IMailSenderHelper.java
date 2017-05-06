package by.kanarski.gksolutions.mailService;

import by.kanarski.gksolutions.wrappers.MimeElement;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IMailSenderHelper {

    void sendMail(String recipientEmail, String subject, String templateName,
                  Context context, List<MimeElement> imageElementList,
                  List<MimeElement> attachmentElementList) throws MessagingException;

    void sendSimpleMail(String recipientEmail, String subject, String templateName, Context context)
            throws MessagingException;

}

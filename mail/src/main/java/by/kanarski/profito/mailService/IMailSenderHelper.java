package by.kanarski.profito.mailService;

import by.kanarski.profito.wrappers.MimeElement;
import org.thymeleaf.context.Context;

import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IMailSenderHelper {

    void sendMail(String recipientEmail, String subject, String templateName,
                  Context context, List<MimeElement> imageElementList,
                  List<MimeElement> attachmentElementList);

    void sendSimpleMail(String recipientEmail, String subject, String templateName, Context context);

}

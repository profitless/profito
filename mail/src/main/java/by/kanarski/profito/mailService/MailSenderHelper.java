package by.kanarski.profito.mailService;

import by.kanarski.profito.wrappers.MimeElement;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class MailSenderHelper implements IMailSenderHelper {
    
    private JavaMailSenderImpl mailSender;
    private TemplateEngine mailTemplateEngine;

    @Autowired
    public MailSenderHelper(JavaMailSenderImpl mailSender, TemplateEngine mailTemplateEngine) {
        this.mailSender = mailSender;
        this.mailTemplateEngine = mailTemplateEngine;
    }

    @Override
    public void sendMail(String recipientEmail, String subject, String templateName,
                         Context context, List<MimeElement> imageElementList,
                         List<MimeElement> attachmentElementList) {
        try {
            MimeMessageHelper message = createSimpleMessage(recipientEmail, subject, templateName, context);
            if (CollectionUtils.isNotEmpty(imageElementList)) {
                for (MimeElement imageElement : imageElementList) {
                    message.addInline(imageElement.getName(),
                            new ByteArrayResource(imageElement.getContent()), imageElement.getContentType());
                }
            }
            if (CollectionUtils.isNotEmpty(attachmentElementList)) {
                for (MimeElement attachmentElement : attachmentElementList) {
                    message.addAttachment(attachmentElement.getName(),
                            new ByteArrayResource(attachmentElement.getContent()), attachmentElement.getContentType());
                }
            }
            this.mailSender.send(message.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendSimpleMail(String recipientEmail, String subject, String templateName, Context context) {
        try {
            MimeMessageHelper message = createSimpleMessage(recipientEmail, subject, templateName, context);
            this.mailSender.send(message.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private MimeMessageHelper createSimpleMessage(String recipientEmail, String subject,
                                                  String templateName, Context context) throws MessagingException {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject(subject);
        message.setFrom(mailSender.getUsername());
        message.setTo(recipientEmail);
        String htmlContent = mailTemplateEngine.process(templateName, context);
        message.setText(htmlContent, true);
        return message;
    }
    
}

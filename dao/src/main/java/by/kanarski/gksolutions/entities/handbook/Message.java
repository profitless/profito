package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.registry.Company;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "message_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Message extends AbstractEntity {

    private static final long serialVersionUID = -238539044868534141L;
    private Date messageTimestamp;
    private Boolean messageIsRead;
    private String messageText;
    private Company companyOwner;
    private Company companyTarget;
    private Message messageParent;

    @Builder
    public Message(Integer messageId, Date messageTimestamp, Boolean messageIsRead, String messageText,
                   Company companyOwner, Company companyTarget, Message messageParent) {
        super(messageId);
        this.messageTimestamp = messageTimestamp;
        this.messageIsRead = messageIsRead;
        this.messageText = messageText;
        this.companyOwner = companyOwner;
        this.companyTarget = companyTarget;
        this.messageParent = messageParent;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getMessageTimestamp() {
        return messageTimestamp;
    }

    @Column(nullable = false)
    public Boolean getMessageIsRead() {
        return messageIsRead;
    }

    @Column(nullable = false)
    public String getMessageText() {
        return messageText;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_owner",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_message_r_company1")
    )
    public Company getCompanyOwner() {
        return companyOwner;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_target",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_message_r_company2")
    )
    public Company getCompanyTarget() {
        return companyTarget;
    }

    @ManyToOne
    @JoinColumn(
            name = "message_id_parent",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_message_h_message1")
    )
    public Message getMessageParent() {
        return messageParent;
    }

    public enum Fields {messageTimestamp, messageIsRead, messageText, companyOwner, companyTarget, messageParent, serialVersionUID}
}

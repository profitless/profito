package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "phone_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Phone extends AbstractEntity {

    private static final long serialVersionUID = 4664553312779046216L;
    private String phoneNumber;
    private PhoneType phoneType;

    @Builder
    public Phone(Integer phoneId, String phoneNumber, PhoneType phoneType) {
        super(phoneId);
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    @Column(nullable = false, length = 30)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @ManyToOne
    @JoinColumn(
            name = "phoneType_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_phone_c_phone_type1")
    )
    public PhoneType getPhoneType() {
        return phoneType;
    }

    public enum Fields {phoneNumber, phoneType, serialVersionUID}
}

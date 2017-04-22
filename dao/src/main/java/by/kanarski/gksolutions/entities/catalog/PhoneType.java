package by.kanarski.gksolutions.entities.catalog;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "phone_type_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PhoneType extends AbstractEntity {

    private static final long serialVersionUID = -8395262742931308553L;
    private String phoneTypeName;

    @Builder
    public PhoneType(Integer phoneTypeId, String phoneTypeName) {
        super(phoneTypeId);
        this.phoneTypeName = phoneTypeName;
    }

    @Column(nullable = false, length = 45)
    public String getPhoneTypeName() {
        return phoneTypeName;
    }

    public enum Fields {phoneTypeName, serialVersionUID}
}

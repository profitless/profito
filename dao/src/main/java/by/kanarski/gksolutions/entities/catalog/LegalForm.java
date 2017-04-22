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
@AttributeOverride(name = "id", column = @Column(name = "legal_form_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LegalForm extends AbstractEntity {

    private static final long serialVersionUID = -4983961249871024646L;
    private String legalFormName;
    private String legalFormNameShort;

    @Builder
    public LegalForm(Integer legalFormId, String legalFormName, String legalFormNameShort) {
        super(legalFormId);
        this.legalFormName = legalFormName;
        this.legalFormNameShort = legalFormNameShort;
    }

    @Column(length = 100)
    public String getLegalFormName() {
        return legalFormName;
    }

    @Column(length = 10)
    public String getLegalFormNameShort() {
        return legalFormNameShort;
    }

    public enum Fields {legalFormName, legalFormNameShort, serialVersionUID}
}

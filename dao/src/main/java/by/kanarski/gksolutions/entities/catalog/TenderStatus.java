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
@AttributeOverride(name = "id", column = @Column(name = "tender_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TenderStatus extends AbstractEntity {

    private static final long serialVersionUID = 8595221787604137852L;
    private String tenderStatusName;

    @Builder
    public TenderStatus(Integer tenderStatusId, String tenderStatusName) {
        super(tenderStatusId);
        this.tenderStatusName = tenderStatusName;
    }

    @Column(nullable = false, length = 145)
    public String getTenderStatusName() {
        return tenderStatusName;
    }

    public enum Fields {tenderStatusName, serialVersionUID}
}

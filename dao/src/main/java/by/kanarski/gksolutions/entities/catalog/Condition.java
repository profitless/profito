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
@AttributeOverride(name = "id", column = @Column(name = "condition_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Condition extends AbstractEntity {

    private static final long serialVersionUID = 2127872298558984644L;
    private String conditionName;

    @Builder
    public Condition(Integer conditionId, String conditionName) {
        super(conditionId);
        this.conditionName = conditionName;
    }

    @Column(length = 100)
    public String getConditionName() {
        return conditionName;
    }

    public enum Fields {conditionName, serialVersionUID}
}

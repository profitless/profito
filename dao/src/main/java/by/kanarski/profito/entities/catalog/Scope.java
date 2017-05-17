package by.kanarski.profito.entities.catalog;

import by.kanarski.profito.entities.AbstractEntity;
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
@AttributeOverride(name = "id", column = @Column(name = "scope_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Scope extends AbstractEntity {

    private static final long serialVersionUID = -7863255880910779510L;
    private String scopeName;

    @Builder
    public Scope(Integer scopeId, String scopeName) {
        super(scopeId);
        this.scopeName = scopeName;
    }

    @Column(nullable = false, unique = true, length = 150)
    public String getScopeName() {
        return scopeName;
    }

    public enum Fields {scopeName, serialVersionUID}
}

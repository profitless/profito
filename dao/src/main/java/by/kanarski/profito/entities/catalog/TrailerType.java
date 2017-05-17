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
@AttributeOverride(name = "id", column = @Column(name = "trailer_type_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TrailerType extends AbstractEntity {

    private static final long serialVersionUID = 9049868102697068115L;
    private String trailerTypeName;

    @Builder
    public TrailerType(Integer id, String trailerTypeName) {
        super(id);
        this.trailerTypeName = trailerTypeName;
    }

    @Column(nullable = false, unique = true, length = 100)
    public String getTrailerTypeName() {
        return trailerTypeName;
    }

    public enum Fields {trailerTypeName, serialVersionUID}
}

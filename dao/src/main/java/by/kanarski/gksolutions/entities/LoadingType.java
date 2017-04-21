package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "loading_type_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LoadingType extends AbstractEntity {

    private static final long serialVersionUID = -5975051171856784631L;
    private String loadingTypeName;

    @Builder
    public LoadingType(Integer loadingTypeId, String loadingTypeName) {
        super(loadingTypeId);
        this.loadingTypeName = loadingTypeName;
    }

    @Column(nullable = false, length = 100)
    public String getLoadingTypeName() {
        return loadingTypeName;
    }

    public enum Fields {loadingTypeName, serialVersionUID}
}

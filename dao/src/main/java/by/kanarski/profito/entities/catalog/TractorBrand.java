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
@AttributeOverride(name = "id", column = @Column(name = "tractor_brand_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TractorBrand extends AbstractEntity {

    private static final long serialVersionUID = 8576706253925811740L;
    private String tractorBrandName;

    @Builder
    public TractorBrand(Integer tractorBrandId, String tractorBrandName) {
        super(tractorBrandId);
        this.tractorBrandName = tractorBrandName;
    }

    @Column(nullable = false, unique = true, length = 100)
    public String getTractorBrandName() {
        return tractorBrandName;
    }

    public enum Fields {tractorBrandName, serialVersionUID}
}

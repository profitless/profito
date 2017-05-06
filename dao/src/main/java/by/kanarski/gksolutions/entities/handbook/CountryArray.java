package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(
                name = "countryArrayPK.country",
                joinColumns = @JoinColumn(
                        name = "country_id",
                        foreignKey = @ForeignKey(
                                name = "fk_h_country_array_h_country1"
                        )
                )),
})
public class CountryArray implements Serializable {

    private static final long serialVersionUID = -575887891979013109L;
    private CountryArrayPK countryArrayPK;

    @Builder
    public CountryArray(CountryArrayPK countryArrayPK) {
        this.countryArrayPK = countryArrayPK;
    }

    @EmbeddedId
    public CountryArrayPK getCountryArrayPK() {
        return countryArrayPK;
    }

    public enum Fields {countryArrayPK, serialVersionUID}
}

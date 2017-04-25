package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 25.04.2017 В модели у country стотит PK, уточнить
@Entity
@AttributeOverride(name = "id", column = @Column(name = "country_array_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CountryArray extends AbstractEntity {

    private static final long serialVersionUID = 6724298298842614176L;
    private Country country;

    @Builder
    public CountryArray(Integer countryArrayId, Country country) {
        super(countryArrayId);
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_country_array_h_country1")
    )
    public Country getCountry() {
        return country;
    }

    public enum Fields {country, serialVersionUID}
}

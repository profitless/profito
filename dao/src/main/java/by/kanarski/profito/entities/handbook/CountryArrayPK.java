package by.kanarski.profito.entities.handbook;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Embeddable
@Data
@NoArgsConstructor
public class CountryArrayPK implements Serializable {

    private static final long serialVersionUID = -8277681503268883004L;
    private Integer countryArrayId;
    private Country country;

    @Builder
    public CountryArrayPK(Integer countryArrayId, Country country) {
        this.countryArrayId = countryArrayId;
        this.country = country;
    }

    @Column(nullable = false)
    public Integer getCountryArrayId() {
        return countryArrayId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "country_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_country_array_h_country1")
    )
    public Country getCountry() {
        return country;
    }
}

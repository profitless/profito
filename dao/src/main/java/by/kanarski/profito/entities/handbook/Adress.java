package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "adress_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Adress extends AbstractEntity {

    private static final long serialVersionUID = 2863736577363347459L;
    private String adressZipcode;
    private String adressFull;
    private Byte adressType;
    private Country country;
    private Integer regionId;

    @Builder
    public Adress(Integer adressId, String adressZipcode, String adressFull, Byte adressType, Country country,
                  Integer regionId) {
        super(adressId);
        this.adressZipcode = adressZipcode;
        this.adressFull = adressFull;
        this.adressType = adressType;
        this.country = country;
        this.regionId = regionId;
    }

    @Column(nullable = false, length = 10)
    public String getAdressZipcode() {
        return adressZipcode;
    }

    @Column(nullable = false, length = 150)
    public String getAdressFull() {
        return adressFull;
    }

    @Column(nullable = false)
    public Byte getAdressType() {
        return adressType;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_adress_c_country1")
    )
    public Country getCountry() {
        return country;
    }

    @Column
    public Integer getRegionId() {
        return regionId;
    }

    public enum Fields {adressZipcode, adressFull, adressType, country, regionId, serialVersionUID}
}

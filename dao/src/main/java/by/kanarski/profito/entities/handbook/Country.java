package by.kanarski.profito.entities.handbook;

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
@AttributeOverride(name = "id", column = @Column(name = "country_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Country extends AbstractEntity {

    private static final long serialVersionUID = -3417111091488851750L;
    private String countryTitleRU;
    private String countryTitleUA;
    private String countryTitleEN;
    private String countryTitleES;
    private String countryTitlePT;
    private String countryTitleDE;
    private String countryTitleFR;
    private String countryTitleIT;
    private String countryTitlePL;
    private String countryTitleLT;
    private String countryTitleLV;
    private String countryTitleCZ;

    @Builder
    public Country(Integer countryId, String countryTitleRU, String countryTitleUA, String countryTitleEN,
                   String countryTitleES, String countryTitlePT, String countryTitleDE, String countryTitleFR,
                   String countryTitleIT, String countryTitlePL, String countryTitleLT, String countryTitleLV,
                   String countryTitleCZ) {
        super(countryId);
        this.countryTitleRU = countryTitleRU;
        this.countryTitleUA = countryTitleUA;
        this.countryTitleEN = countryTitleEN;
        this.countryTitleES = countryTitleES;
        this.countryTitlePT = countryTitlePT;
        this.countryTitleDE = countryTitleDE;
        this.countryTitleFR = countryTitleFR;
        this.countryTitleIT = countryTitleIT;
        this.countryTitlePL = countryTitlePL;
        this.countryTitleLT = countryTitleLT;
        this.countryTitleLV = countryTitleLV;
        this.countryTitleCZ = countryTitleCZ;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleRU() {
        return countryTitleRU;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleUA() {
        return countryTitleUA;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleEN() {
        return countryTitleEN;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleES() {
        return countryTitleES;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitlePT() {
        return countryTitlePT;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleDE() {
        return countryTitleDE;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleFR() {
        return countryTitleFR;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleIT() {
        return countryTitleIT;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitlePL() {
        return countryTitlePL;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleLT() {
        return countryTitleLT;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleLV() {
        return countryTitleLV;
    }

    @Column(nullable = false, length = 60)
    public String getCountryTitleCZ() {
        return countryTitleCZ;
    }

    public enum Fields {countryTitleUA, countryTitleEN, countryTitleES, countryTitlePT, countryTitleDE, countryTitleFR, countryTitleIT, countryTitlePL, countryTitleLT, countryTitleLV, countryTitleCZ, countryTitleRU}
}

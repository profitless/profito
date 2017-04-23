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
@AttributeOverride(name = "id", column = @Column(name = "currency_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Currency extends AbstractEntity {

    private static final long serialVersionUID = 7428807893454544947L;
    private String currencyName;
    private String currencyAbbr;

    @Builder
    public Currency(Integer currencyId, String currencyName, String currencyAbbr) {
        super(currencyId);
        this.currencyName = currencyName;
        this.currencyAbbr = currencyAbbr;
    }

    @Column(nullable = false, length = 20)
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(nullable = false, length = 4)
    public String getCurrencyAbbr() {
        return currencyAbbr;
    }

    public enum Fields {currencyName, currencyAbbr, serialVersionUID}
}

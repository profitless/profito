package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.Condition;
import by.kanarski.gksolutions.entities.catalog.Currency;
import by.kanarski.gksolutions.entities.registry.Company;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */
// TODO: 25.04.2017 ONEtoONE, или нет, ВАЖНО!!!?
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CurrencyCondition {

    private Company company;
    private Currency currency;
    private Integer currencyConditionsDays;
    private Condition condition;

    @Builder
    public CurrencyCondition(Company company, Currency currency, Integer currencyConditionsDays, Condition condition) {
        this.company = company;
        this.currency = currency;
        this.currencyConditionsDays = currencyConditionsDays;
        this.condition = condition;
    }

    @OneToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_currency_condition_h_company1")
    )
    public Company getCompany() {
        return company;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_currency_condition_c_currency1")
    )
    public Currency getCurrency() {
        return currency;
    }

    @Column(nullable = false)
    public Integer getCurrencyConditionsDays() {
        return currencyConditionsDays;
    }

    @ManyToOne
    @JoinColumn(
            name = "condition_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_currency_condition_c_condition1")
    )
    public Condition getCondition() {
        return condition;
    }

    public enum Fields {currency, currencyConditionsDays, condition, company}
}

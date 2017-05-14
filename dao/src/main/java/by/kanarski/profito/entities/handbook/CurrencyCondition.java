package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.Condition;
import by.kanarski.profito.entities.catalog.Currency;
import by.kanarski.profito.entities.registry.Company;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
public class CurrencyCondition implements Serializable {

    private static final long serialVersionUID = -2638784228754429230L;
    private Integer companyId;
    private Company company;
    private Currency currency;
    private Integer currencyConditionsDays;
    private Condition condition;

    @Builder
    public CurrencyCondition(Integer companyId, Company company, Currency currency, Integer currencyConditionsDays, Condition condition) {
        this.companyId = companyId;
        this.company = company;
        this.currency = currency;
        this.currencyConditionsDays = currencyConditionsDays;
        this.condition = condition;
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "company"))
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    @OneToOne
    @PrimaryKeyJoinColumn(
            name = "company_id",
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

    public enum Fields {companyId, company, currency, currencyConditionsDays, condition, serialVersionUID}
}

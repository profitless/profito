package by.kanarski.profito.entities.journal;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.Currency;
import by.kanarski.profito.entities.registry.Company;
import by.kanarski.profito.entities.registry.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "company_payment_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompanyPayment extends AbstractEntity {

    private static final long serialVersionUID = -6962130811171778521L;
    private Company company;
    private Date companyPaymentDate;
    private User user;
    private Currency currency;
    private Double companyPaymentValue;

    @Builder
    public CompanyPayment(Integer companyPaymentId, Company company, Date companyPaymentDate, User user,
                          Currency currency, Double companyPaymentValue) {
        super(companyPaymentId);
        this.company = company;
        this.companyPaymentDate = companyPaymentDate;
        this.user = user;
        this.currency = currency;
        this.companyPaymentValue = companyPaymentValue;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_j_company_payment_h_company1")
    )
    public Company getCompany() {
        return company;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getCompanyPaymentDate() {
        return companyPaymentDate;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_j_company_payment_r_user1")
    )
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_j_company_payment_c_currency1")
    )
    public Currency getCurrency() {
        return currency;
    }

    @Column
    public Double getCompanyPaymentValue() {
        return companyPaymentValue;
    }

    public enum Fields {company, companyPaymentDate, user, currency, companyPaymentValue, serialVersionUID}
}

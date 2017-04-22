package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.Currency;
import by.kanarski.gksolutions.entities.handbook.Document;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "policy_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Policy extends AbstractEntity {

    private static final long serialVersionUID = -9018074166013990428L;
    private Document document;
    private String policyOrgName;
    private String policyNumber;
    private Date policyCreatedDate;
    private Date policyDateFrom;
    private Date policyDateTo;
    private Double policySum;
    private Currency currency;

    @Builder
    public Policy(Integer policyId, Document document, String policyOrgName, String policyNumber,
                  Date policyCreatedDate, Date policyDateFrom, Date policyDateTo,
                  Double policySum, Currency currency) {
        super(policyId);
        this.document = document;
        this.policyOrgName = policyOrgName;
        this.policyNumber = policyNumber;
        this.policyCreatedDate = policyCreatedDate;
        this.policyDateFrom = policyDateFrom;
        this.policyDateTo = policyDateTo;
        this.policySum = policySum;
        this.currency = currency;
    }

    @ManyToOne
    @JoinColumn(
            name = "document_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_policy_h_document1")
    )
    public void setDocument(Document document) {
        this.document = document;
    }

    @Column(nullable = false, length = 100)
    public void setPolicyOrgName(String policyOrgName) {
        this.policyOrgName = policyOrgName;
    }

    @Column(nullable = false, length = 30)
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @Column(nullable = false)
    public void setPolicyCreatedDate(Date policyCreatedDate) {
        this.policyCreatedDate = policyCreatedDate;
    }

    @Column(nullable = false)
    public void setPolicyDateFrom(Date policyDateFrom) {
        this.policyDateFrom = policyDateFrom;
    }

    @Column(nullable = false)
    public void setPolicyDateTo(Date policyDateTo) {
        this.policyDateTo = policyDateTo;
    }

    @Column(nullable = false)
    public void setPolicySum(Double policySum) {
        this.policySum = policySum;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_policy_c_currency1")
    )
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public enum Fields {document, policyOrgName, policyNumber, policyCreatedDate, policyDateFrom, policyDateTo, policySum, currency, serialVersionUID}
}

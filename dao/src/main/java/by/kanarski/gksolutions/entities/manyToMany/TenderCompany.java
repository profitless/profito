package by.kanarski.gksolutions.entities.manyToMany;

import by.kanarski.gksolutions.entities.registry.Company;
import by.kanarski.gksolutions.entities.registry.Tender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
                name = "tenderCompanyPK.tender",
                joinColumns = @JoinColumn(
                        name = "tender_id",
                        foreignKey = @ForeignKey(
                                name = "fk_nn_tender_company_r_tender1"
                        )
                )
        ),
        @AssociationOverride(
                name = "tenderCompanyPK.company",
                joinColumns = @JoinColumn(
                        name = "company_id",
                        foreignKey = @ForeignKey(
                                name = "fk_nn_tender_company_h_company1"
                        )
                )),
})
public class TenderCompany implements Serializable {

    private static final long serialVersionUID = 1064055254354406649L;
    private TenderCompanyPK tenderCompanyPK;
    private Byte tenderWinner;
    private Float tenderShare;

    @Builder
    public TenderCompany(TenderCompanyPK tenderCompanyPK, Byte tenderWinner, Float tenderShare) {
        this.tenderCompanyPK = tenderCompanyPK;
        this.tenderWinner = tenderWinner;
        this.tenderShare = tenderShare;
    }

    @EmbeddedId
    public TenderCompanyPK getTenderCompanyPK() {
        return tenderCompanyPK;
    }

    @Transient
    public Tender getTender() {
        return getTenderCompanyPK().getTender();
    }

    public void setTender(Tender tender) {
        getTenderCompanyPK().setTender(tender);
    }

    @Transient
    public Company getCompany() {
        return getTenderCompanyPK().getCompany();
    }

    public void setCompany(Company company) {
        getTenderCompanyPK().setCompany(company);
    }

    @Column
    public Byte getTenderWinner() {
        return tenderWinner;
    }

    @Column
    public Float getTenderShare() {
        return tenderShare;
    }

    public enum Fields {tenderCompanyPK, tenderWinner, tenderShare, serialVersionUID}
}

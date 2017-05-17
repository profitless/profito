package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.registry.Company;
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
@AttributeOverride(name = "id", column = @Column(name = "partner_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Partner extends AbstractEntity {

    private static final long serialVersionUID = -338856079757817657L;
    private Company author;
    private Company target;
    private String partnerInfo;
    private String partnerContractInfo;
    private Date partnerContractStart;
    private Date partnerContractEnd;

    public Partner(Integer partnerId, Company author, Company target, String partnerInfo,
                   String partnerContractInfo, Date partnerContractStart, Date partnerContractEnd) {
        super(partnerId);
        this.author = author;
        this.target = target;
        this.partnerInfo = partnerInfo;
        this.partnerContractInfo = partnerContractInfo;
        this.partnerContractStart = partnerContractStart;
        this.partnerContractEnd = partnerContractEnd;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_author",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_partner_h_company1")
    )
    public Company getAuthor() {
        return author;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_target",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_partner_h_company2")
    )
    public Company getTarget() {
        return target;
    }

    @Column(length = 245)
    public String getPartnerInfo() {
        return partnerInfo;
    }

    @Column(length = 100)
    public String getPartnerContractInfo() {
        return partnerContractInfo;
    }

    @Column
    public Date getPartnerContractStart() {
        return partnerContractStart;
    }

    @Column
    public Date getPartnerContractEnd() {
        return partnerContractEnd;
    }

    public enum Fields {author, target, partnerInfo, partnerContractInfo, partnerContractStart, partnerContractEnd, serialVersionUID}
}

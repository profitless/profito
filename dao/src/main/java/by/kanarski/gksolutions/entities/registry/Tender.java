package by.kanarski.gksolutions.entities.registry;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.Scope;
import by.kanarski.gksolutions.entities.manyToMany.TenderCompany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "tender_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Tender extends AbstractEntity {

    private static final long serialVersionUID = -2584976875432226881L;
    private Company company;
    private Integer tenderCarQuantity;
    private Date tenderStartTime;
    private Date tenderEndTime;
    private String tenderRoute;
    private Double tenderMaxBid;
    private Double tenderMinBid;
    private Double tenderCurrentBid;
    private Double tenderPrice;
    private Boolean tenderIsTransportInfoRequired;
    private Boolean tenderIsDriverInfoRequired;
    private Integer tenderWinnersCount;
    private String tenderWinnersShare;
    private Date tenderPeriodStart;
    private Date tenderPeriodEnd;
    private Scope scope;
    private Double tenderDataEnterTime;
    private Boolean tenderToAuction;
    private Boolean tenderTemplBet;
    private Boolean tenderTenderBet;
    private Tender tenderStatus;
    private Set<TenderCompany> tenderCompanySet;

    @Builder
    public Tender(Integer tenderId, Company company, Integer tenderCarQuantity, Date tenderStartTime,
                  Date tenderEndTime, String tenderRoute, Double tenderMaxBid, Double tenderMinBid,
                  Double tenderCurrentBid, Double tenderPrice, Boolean tenderIsTransportInfoRequired,
                  Boolean tenderIsDriverInfoRequired, Integer tenderWinnersCount, String tenderWinnersShare,
                  Date tenderPeriodStart, Date tenderPeriodEnd, Scope scope, Double tenderDataEnterTime,
                  Boolean tenderToAuction, Boolean tenderTemplBet, Boolean tenderTenderBet, Tender tenderStatus,
                  Set<TenderCompany> tenderCompanySet) {
        super(tenderId);
        this.company = company;
        this.tenderCarQuantity = tenderCarQuantity;
        this.tenderStartTime = tenderStartTime;
        this.tenderEndTime = tenderEndTime;
        this.tenderRoute = tenderRoute;
        this.tenderMaxBid = tenderMaxBid;
        this.tenderMinBid = tenderMinBid;
        this.tenderCurrentBid = tenderCurrentBid;
        this.tenderPrice = tenderPrice;
        this.tenderIsTransportInfoRequired = tenderIsTransportInfoRequired;
        this.tenderIsDriverInfoRequired = tenderIsDriverInfoRequired;
        this.tenderWinnersCount = tenderWinnersCount;
        this.tenderWinnersShare = tenderWinnersShare;
        this.tenderPeriodStart = tenderPeriodStart;
        this.tenderPeriodEnd = tenderPeriodEnd;
        this.scope = scope;
        this.tenderDataEnterTime = tenderDataEnterTime;
        this.tenderToAuction = tenderToAuction;
        this.tenderTemplBet = tenderTemplBet;
        this.tenderTenderBet = tenderTenderBet;
        this.tenderStatus = tenderStatus;
        this.tenderCompanySet = tenderCompanySet;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_tender_h_company_info1")
    )
    public Company getCompany() {
        return company;
    }

    @Column(nullable = false)
    public Integer getTenderCarQuantity() {
        return tenderCarQuantity;
    }

    @Column(nullable = false, columnDefinition = "DATETIME")
    public Date getTenderStartTime() {
        return tenderStartTime;
    }

    @Column(nullable = false, columnDefinition = "DATETIME")
    public Date getTenderEndTime() {
        return tenderEndTime;
    }

    @Column(nullable = false, length = 150)
    public String getTenderRoute() {
        return tenderRoute;
    }

    @Column(nullable = false)
    public Double getTenderMaxBid() {
        return tenderMaxBid;
    }

    @Column(nullable = false)
    public Double getTenderMinBid() {
        return tenderMinBid;
    }

    @Column(nullable = false)
    public Double getTenderCurrentBid() {
        return tenderCurrentBid;
    }

    @Column(nullable = false)
    public Double getTenderPrice() {
        return tenderPrice;
    }

    @Column(columnDefinition = "TINYINT(1)")
    public Boolean getTenderIsTransportInfoRequired() {
        return tenderIsTransportInfoRequired;
    }

    @Column(columnDefinition = "TINYINT(1)")
    public Boolean getTenderIsDriverInfoRequired() {
        return tenderIsDriverInfoRequired;
    }

    @Column(nullable = false)
    public Integer getTenderWinnersCount() {
        return tenderWinnersCount;
    }

    @Column(nullable = false, length = 45)
    public String getTenderWinnersShare() {
        return tenderWinnersShare;
    }

    @Column(nullable = false, columnDefinition = "DATETIME")
    public Date getTenderPeriodStart() {
        return tenderPeriodStart;
    }

    @Column(nullable = false, columnDefinition = "DATETIME")
    public Date getTenderPeriodEnd() {
        return tenderPeriodEnd;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_tender_c_scope1")
    )
    public Scope getScope() {
        return scope;
    }

    @Column(nullable = false)
    public Double getTenderDataEnterTime() {
        return tenderDataEnterTime;
    }

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    public Boolean getTenderToAuction() {
        return tenderToAuction;
    }

    @Column(columnDefinition = "TINYINT(1)")
    public Boolean getTenderTemplBet() {
        return tenderTemplBet;
    }

    @Column(columnDefinition = "TINYINT(1)")
    public Boolean getTenderTenderBet() {
        return tenderTenderBet;
    }

    @ManyToOne
    @JoinColumn(
            name = "tender_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_tender_c_tender_status1")
    )
    public Tender getTenderStatus() {
        return tenderStatus;
    }

    @OneToMany(mappedBy = "tenderCompanyPK.tender", cascade = CascadeType.ALL)
    public Set<TenderCompany> getTenderCompanySet() {
        return tenderCompanySet;
    }

    public enum Fields {company, tenderCarQuantity, tenderStartTime, tenderEndTime, tenderRoute, tenderMaxBid, tenderMinBid, tenderCurrentBid, tenderPrice, tenderIsTransportInfoRequired, tenderIsDriverInfoRequired, tenderWinnersCount, tenderWinnersShare, tenderPeriodStart, tenderPeriodEnd, scope, tenderDataEnterTime, tenderToAuction, tenderTemplBet, tenderTenderBet, tenderStatus, tenderCompanySet, serialVersionUID}
}

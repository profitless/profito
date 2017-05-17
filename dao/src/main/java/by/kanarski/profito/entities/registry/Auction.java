package by.kanarski.profito.entities.registry;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.AuctionStatus;
import by.kanarski.profito.entities.catalog.Scope;
import by.kanarski.profito.entities.manyToMany.AuctionCompany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "auction_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Auction extends AbstractEntity {

    private static final long serialVersionUID = 3513212414129467391L;
    private Request request;
    private Company company;
    private Double auctionIncrement;
    private Date auctionStartTime;
    private Date auctionEndTime;
    private Date auctionPublicationTime;
    private Double auctionMaxBid;
    private Double auctionMinBid;
    private Scope scope;
    private Double auctionDataEnterTime;
    private AuctionStatus auctionStatus;
    private Boolean auctionFindMinBid;
    private Boolean auctionGrowthBid;
    private Set<AuctionCompany> companyAuctoinCompanySet;

    @Builder
    public Auction(Integer auctionId, Request request, Company company, Double auctionIncrement,
                   Date auctionStartTime, Date auctionEndTime, Date auctionPublicationTime, Double auctionMaxBid,
                   Double auctionMinBid, Scope scope, Double auctionDataEnterTime, AuctionStatus auctionStatus,
                   Boolean auctionFindMinBid, Boolean auctionGrowthBid, Set<AuctionCompany> companyAuctoinCompanySet) {
        super(auctionId);
        this.request = request;
        this.company = company;
        this.auctionIncrement = auctionIncrement;
        this.auctionStartTime = auctionStartTime;
        this.auctionEndTime = auctionEndTime;
        this.auctionPublicationTime = auctionPublicationTime;
        this.auctionMaxBid = auctionMaxBid;
        this.auctionMinBid = auctionMinBid;
        this.scope = scope;
        this.auctionDataEnterTime = auctionDataEnterTime;
        this.auctionStatus = auctionStatus;
        this.auctionFindMinBid = auctionFindMinBid;
        this.auctionGrowthBid = auctionGrowthBid;
        this.companyAuctoinCompanySet = companyAuctoinCompanySet;
    }

    @ManyToOne
    @JoinColumn(
            name = "request_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_auction_r_request1")
    )
    public Request getRequest() {
        return request;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_auction_h_company1")
    )
    public Company getCompany() {
        return company;
    }

    @Column
    public Double getAuctionIncrement() {
        return auctionIncrement;
    }

    @Column(columnDefinition = "DATETIME")
    public Date getAuctionStartTime() {
        return auctionStartTime;
    }

    @Column(columnDefinition = "DATETIME")
    public Date getAuctionEndTime() {
        return auctionEndTime;
    }

    @Column(columnDefinition = "DATETIME")
    public Date getAuctionPublicationTime() {
        return auctionPublicationTime;
    }

    @Column
    public Double getAuctionMaxBid() {
        return auctionMaxBid;
    }

    @Column
    public Double getAuctionMinBid() {
        return auctionMinBid;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_auction_c_scope1")
    )
    public Scope getScope() {
        return scope;
    }

    @Column(nullable = false)
    public Double getAuctionDataEnterTime() {
        return auctionDataEnterTime;
    }

    @ManyToOne
    @JoinColumn(
            name = "auction_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_auction_c_auction_status1")
    )
    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getAuctionFindMinBid() {
        return auctionFindMinBid;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getAuctionGrowthBid() {
        return auctionGrowthBid;
    }

    @OneToMany(mappedBy = "auctionCompanyPK.auction", cascade = CascadeType.ALL)
    public Set<AuctionCompany> getCompanyAuctoinCompanySet() {
        return companyAuctoinCompanySet;
    }

    public enum Fields {request, company, auctionIncrement, auctionStartTime, auctionEndTime, auctionPublicationTime, auctionMaxBid, auctionMinBid, scope, auctionDataEnterTime, auctionStatus, auctionFindMinBid, auctionGrowthBid, companyAuctoinCompanySet, serialVersionUID}
}

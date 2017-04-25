package by.kanarski.gksolutions.entities.registry;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.AuctionStatus;
import by.kanarski.gksolutions.entities.catalog.Scope;
import by.kanarski.gksolutions.entities.manyToMany.AuctionCompany;
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
@AttributeOverride(name = "id", column = @Column(name = "auction_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Auction extends AbstractEntity {

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
    private Set<AuctionCompany> companyAuctoinCompanySet;

    @OneToMany(mappedBy = "auctionCompanyPK.auction", cascade = CascadeType.ALL)
    public Set<AuctionCompany> getCompanyAuctoinCompanySet() {
        return companyAuctoinCompanySet;
    }
}

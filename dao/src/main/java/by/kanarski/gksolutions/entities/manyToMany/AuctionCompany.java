package by.kanarski.gksolutions.entities.manyToMany;

import by.kanarski.gksolutions.entities.Auction;
import by.kanarski.gksolutions.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverrides({
        @AssociationOverride(
                name = "auctionCompanyPK.auction",
                joinColumns = @JoinColumn(
                        name = "auction_id",
                        nullable = false,
                        foreignKey = @ForeignKey(
                                name = "fk_nn_auction_company_f_auction1"
                        )
                )),
        @AssociationOverride(
                name = "auctionCompanyPK.company",
                joinColumns = @JoinColumn(
                        name = "company_id",
                        nullable = false,
                        foreignKey = @ForeignKey(
                                name = "fk_nn_auction_company_h_company1"
                        )
                ))
})
public class AuctionCompany {

    private AuctionCompanyPK auctionCompanyPK;
    private Byte auctionWinner;

    @EmbeddedId
    public AuctionCompanyPK getAuctionCompanyPK() {
        return auctionCompanyPK;
    }
    
    @Transient
    public Auction getAuction() {
        return getAuctionCompanyPK().getAuction();
    }

    public void setAuction(Auction auction) {
        getAuctionCompanyPK().setAuction(auction);
    }

    @Transient
    public Company getCompany() {
        return getAuctionCompanyPK().getCompany();
    }

    public void setCompany(Company company) {
        getAuctionCompanyPK().setCompany(company);
    }

    @Column(nullable = false)
    public Byte getAuctionWinner() {
        return auctionWinner;
    }

}

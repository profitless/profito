package by.kanarski.gksolutions.entities.manyToMany;

import by.kanarski.gksolutions.entities.registry.Auction;
import by.kanarski.gksolutions.entities.registry.Company;
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
public class AuctionCompany implements Serializable {

    private static final long serialVersionUID = 7895426086815048958L;
    private AuctionCompanyPK auctionCompanyPK;
    private Byte auctionWinner;

    @Builder
    public AuctionCompany(AuctionCompanyPK auctionCompanyPK, Byte auctionWinner) {
        this.auctionCompanyPK = auctionCompanyPK;
        this.auctionWinner = auctionWinner;
    }

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

    public enum Fields {auctionCompanyPK, auctionWinner, serialVersionUID}
}

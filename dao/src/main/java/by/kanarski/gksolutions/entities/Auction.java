package by.kanarski.gksolutions.entities;

import by.kanarski.gksolutions.entities.manyToMany.AuctionCompany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 21.04.2017 Не мое
@Entity
@AttributeOverride(name = "id", column = @Column(name = "auction_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Auction extends AbstractEntity {

    private Set<AuctionCompany> companyAuctoinCompanySet;

    @OneToMany(mappedBy = "auctionCompanyPK.auction", cascade = CascadeType.ALL)
    public Set<AuctionCompany> getCompanyAuctoinCompanySet() {
        return companyAuctoinCompanySet;
    }
}

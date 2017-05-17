package by.kanarski.profito.entities.manyToMany;

import by.kanarski.profito.entities.registry.Auction;
import by.kanarski.profito.entities.registry.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Embeddable
@Data
@NoArgsConstructor
public class AuctionCompanyPK implements Serializable {

    private static final long serialVersionUID = 8903415450246422230L;
    private Auction auction;
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL)
    public Auction getAuction() {
        return auction;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Company getCompany() {
        return company;
    }
}

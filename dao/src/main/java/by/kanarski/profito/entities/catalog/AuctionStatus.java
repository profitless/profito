package by.kanarski.profito.entities.catalog;

import by.kanarski.profito.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "auction_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AuctionStatus extends AbstractEntity {

    private static final long serialVersionUID = -5506014887011654070L;
    private String auctionStatusName;

    @Builder
    public AuctionStatus(Integer auctionStatusId, String auctionStatusName) {
        super(auctionStatusId);
        this.auctionStatusName = auctionStatusName;
    }

    @Column(nullable = false, length = 145)
    public String getAuctionStatusName() {
        return auctionStatusName;
    }

    public enum Fields {auctionStatusName, serialVersionUID}
}

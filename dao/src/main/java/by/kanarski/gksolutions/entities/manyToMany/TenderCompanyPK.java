package by.kanarski.gksolutions.entities.manyToMany;

import by.kanarski.gksolutions.entities.Company;
import by.kanarski.gksolutions.entities.Tender;
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
public class TenderCompanyPK implements Serializable {

    private static final long serialVersionUID = 3399824326561856897L;
    private Tender tender;
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL)
    public Tender getTender() {
        return tender;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Company getCompany() {
        return company;
    }
}

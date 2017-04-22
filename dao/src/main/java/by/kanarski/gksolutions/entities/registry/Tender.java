package by.kanarski.gksolutions.entities.registry;

import by.kanarski.gksolutions.entities.manyToMany.TenderCompany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 21.04.2017 не мое
@Entity
@AttributeOverride(name = "id", column = @Column(name = "tender_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Tender {

    private Set<TenderCompany> tenderCompanySet;

    @OneToMany(mappedBy = "tenderCompanyPK.tender", cascade = CascadeType.ALL)
    public Set<TenderCompany> getTenderCompanySet() {
        return tenderCompanySet;
    }
}

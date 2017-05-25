package by.kanarski.profito.entities.catalog;

import by.kanarski.profito.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "company_type_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompanyType extends AbstractEntity {

    public static final Integer CUSTOMER = 1;
    public static final Integer FORWARDER = 2;
    public static final Integer EXPEDITOR = 3;

    private static final long serialVersionUID = 2620672492276264928L;
    private String companyTypeName;

    @Builder
    public CompanyType(Integer companyTypeId, String companyTypeName) {
        super(companyTypeId);
        this.companyTypeName = companyTypeName;
    }

    @Column(nullable = false, unique = true, length = 45)
    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public enum Fields {companyTypeName, serialVersionUID}
}

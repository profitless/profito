package by.kanarski.gksolutions.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCompanyDto implements Serializable {

    private String companyName;
    private String registrationNumber;
    private Integer legalFormId;
    private Integer countryId;
    private Integer regionId;
    // TODO: 23.04.2017 Продолжить

}

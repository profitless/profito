package by.kanarski.gksolutions.dto.company;

import by.kanarski.gksolutions.dto.bankAccount.BankAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCompanyDto implements Serializable {

    private static final long serialVersionUID = 2800353908359292488L;
    private String companyName;
    private String registrationNumber;
    private Integer legalFormId;
    private Integer countryId;
    private Integer regionId;
    private Integer cityId;
    private Set<String> phoneSet;
    private BankAccountDto bankAccount;
    private String additionNumber;
    private MultipartFile registrationCetificate;


}

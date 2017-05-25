package by.kanarski.profito.dto.company;

import by.kanarski.profito.dto.address.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyInfoDto implements Serializable {

    private static final long serialVersionUID = 2800353908359292488L;
    private String companyName;
    private Integer companyType;
    private String registrationNumber;
    private String additionNumber;
    private Integer legalFormId;
    private MultipartFile registrationCetificate;
    private MultipartFile policy;
    private AddressDto jurAddress;
    private AddressDto factAddress;
    private AddressDto postAddress;

}

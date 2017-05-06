package by.kanarski.gksolutions.dto.forms;

import by.kanarski.gksolutions.dto.CompanyDto;
import by.kanarski.gksolutions.dto.bank.BankDto;
import by.kanarski.gksolutions.dto.user.FirstUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCompanyForm {

    private FirstUserDto firstUser;
    private CompanyDto company;

}

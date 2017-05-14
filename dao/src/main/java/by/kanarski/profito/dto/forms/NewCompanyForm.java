package by.kanarski.profito.dto.forms;

import by.kanarski.profito.dto.CompanyDto;
import by.kanarski.profito.dto.bank.BankDto;
import by.kanarski.profito.dto.user.FirstUserDto;
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

package by.kanarski.gksolutions.dto.bankAccount;

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
public class BankAccountDto {

    private Integer bankId;
    private String bankAccountNumber;

}

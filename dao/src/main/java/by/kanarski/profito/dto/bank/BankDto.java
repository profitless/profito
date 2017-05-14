package by.kanarski.profito.dto.bank;

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
public class BankDto implements Serializable {

    private static final long serialVersionUID = 8897577895629605301L;
    private String bankName;
    private String bankCode;
    private String bankAccountNumber;

}

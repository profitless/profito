package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "bank_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Bank extends AbstractEntity {

    private static final long serialVersionUID = -6757817059823394991L;
    private String bankName;
    private String bankAdress;
    private String bankCode;

    @Builder
    public Bank(Integer bankId, String bankName, String bankAdress, String bankCode) {
        super(bankId);
        this.bankName = bankName;
        this.bankAdress = bankAdress;
        this.bankCode = bankCode;
    }

    @Column(nullable = false, length = 45)
    public String getBankName() {
        return bankName;
    }

    @Column(nullable = false, length = 200)
    public String getBankAdress() {
        return bankAdress;
    }

    @Column(length = 20)
    public String getBankCode() {
        return bankCode;
    }

    public enum Fields {bankName, bankAdress, bankCode, serialVersionUID}
}

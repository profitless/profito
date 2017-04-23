package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.Currency;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "bank_account_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BankAccount extends AbstractEntity {

    private static final long serialVersionUID = 5511387062842122007L;
    private Bank bank;
    private Currency currency;
    private String bankAccountNumber;
    private Boolean useDefault;

    @Builder
    public BankAccount(Integer bankAccountId, Bank bank, Currency currency, String bankAccountNumber,
                       Boolean useDefault) {
        super(bankAccountId);
        this.bank = bank;
        this.currency = currency;
        this.bankAccountNumber = bankAccountNumber;
        this.useDefault = useDefault;
    }

    @ManyToOne
    @JoinColumn(
            name = "bank_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_bank_account_c_bank1")
    )
    public Bank getBank() {
        return bank;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_bank_account_c_currency1")
    )
    public Currency getCurrency() {
        return currency;
    }

    @Column(nullable = false, length = 45)
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    public Boolean getUseDefault() {
        return useDefault;
    }


    public enum Fields {bank, currency, bankAccountNumber, useDefault, serialVersionUID}
}

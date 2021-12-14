package es.care.sf.scenariosystem.domain.debitcard.eurobits.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardEurobits {

    private String cardType;
    private String cardNumber;
    private MoneyEurobits disposed;
    private String expirationDate;
    private String associatedAccount;
    private String webAlias;
    private List<DebitCardTransaction> transactions;
}

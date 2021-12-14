package es.care.sf.scenariosystem.domain.creditcard.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardEurobits {

    private String cardType;
    private String cardNumber;
    private MoneyEurobits limit;
    private MoneyEurobits disposed;
    private MoneyEurobits available;
    private String expirationDate;
    private String webAlias;
    private String paymentDueDate;
    private MoneyEurobits paymentAmount;
    private String billingPeriodStart ;
    private String billingPeriodEnd;
    private List<CreditCardTransaction> transactions;
}

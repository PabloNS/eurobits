package es.care.sf.scenariosystem.domain.creditcard.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardTransaction {

    private String transactionType;
    private String valueDate;
    private String description;
    private MoneyEurobits amount;
    private String comments;
}

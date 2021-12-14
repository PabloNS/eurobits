package es.care.sf.scenariosystem.domain.credit.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditTransactionEurobits {

    private String transactionType;
    private String operationDate;
    private String valueDate;
    private String description;
    private MoneyEurobits amount;
    private String payee;
    private String payer;
    private MoneyEurobits balance;
    private String reference;
}

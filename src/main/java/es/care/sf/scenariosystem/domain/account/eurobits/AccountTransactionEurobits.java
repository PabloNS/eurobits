package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionEurobits {

    private String transactionType;
    private String operationDate;
    private String valueDate;
    private String description;
    private MoneyEurobits amount;
    private String reference;
    private String payer;
    private String payee;
    private MoneyEurobits balance;
}

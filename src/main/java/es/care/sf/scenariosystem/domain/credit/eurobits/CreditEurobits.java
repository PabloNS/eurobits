package es.care.sf.scenariosystem.domain.credit.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditEurobits {

    private String bank;
    private String branch;
    private String controlDigits;
    private String account;
    private MoneyEurobits balance;
    private MoneyEurobits availableBalance;
    private String webAlias;
    private List<CreditTransactionEurobits> transactions;
}

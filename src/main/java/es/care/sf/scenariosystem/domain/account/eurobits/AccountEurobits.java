package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEurobits {

    private String bank;
    private String branch;
    private String controlDigits;
    private String account;
    private MoneyEurobits balance;
    private String webAlias ;
    private List<AccountTransactionEurobits> transactions;
}

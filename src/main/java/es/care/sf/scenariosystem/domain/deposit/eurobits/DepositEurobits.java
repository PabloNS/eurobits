package es.care.sf.scenariosystem.domain.deposit.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import es.care.sf.scenariosystem.domain.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositEurobits {

    private String bank;
    private String branch;
    private String controlDigits;
    private String accountNumber;
    private String number;
    private MoneyEurobits balance;
    private InterestEurobits interest;
    private Period duration;
    private String webAlias;
}

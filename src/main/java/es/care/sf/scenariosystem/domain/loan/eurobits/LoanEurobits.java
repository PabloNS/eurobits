package es.care.sf.scenariosystem.domain.loan.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import es.care.sf.scenariosystem.domain.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanEurobits {

    private String bank;
    private String branch;
    private String controlDigits;
    private String accountNumber;
    private String webAlias;
    private String accountType;
    private Period period;
    //initBalance in API doc
    private MoneyEurobits initialBalance;
    private MoneyEurobits debt;
    private MoneyEurobits repayment;
    private String repaymentDate;
    private String revisionDate;
    private LoanRateEurobits loanRates;
}

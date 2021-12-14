package es.care.sf.scenariosystem.domain.scenario.transformed;

import es.care.sf.scenariosystem.domain.account.transformed.Account;
import es.care.sf.scenariosystem.domain.accountholder.eurobits.AccountHolderEurobits;
import es.care.sf.scenariosystem.domain.creditcard.eurobits.CreditCardEurobits;
import es.care.sf.scenariosystem.domain.deposit.eurobits.DepositEurobits;
import es.care.sf.scenariosystem.domain.fund.eurobits.FundEurobits;
import es.care.sf.scenariosystem.domain.loan.eurobits.LoanEurobits;
import es.care.sf.scenariosystem.domain.pensionplan.eurobits.PensionPlanEurobits;
import es.care.sf.scenariosystem.domain.share.eurobits.ShareEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankExtract {

    private List<Account> accounts = new ArrayList<>();
    private List<CreditCardEurobits> creditCards;
    private List<DepositEurobits> deposites;
    private List<LoanEurobits> loan;
    private List<FundEurobits> funds;
    private List<ShareEurobits> share;
    private List<AccountHolderEurobits> accountHolders;
    private List<?> loyalty;
    private List<PensionPlanEurobits> pensionPlans;
}

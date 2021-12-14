package es.care.sf.scenariosystem.domain.scenario.eurobits;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.account.eurobits.AggregationInfoEurobits;
import es.care.sf.scenariosystem.domain.accountholder.eurobits.AccountHolderEurobits;
import es.care.sf.scenariosystem.domain.credit.eurobits.CreditEurobits;
import es.care.sf.scenariosystem.domain.creditcard.eurobits.CreditCardEurobits;
import es.care.sf.scenariosystem.domain.debitcard.eurobits.eurobits.DebitCardEurobits;
import es.care.sf.scenariosystem.domain.deposit.eurobits.DepositEurobits;
import es.care.sf.scenariosystem.domain.directdebit.eurobits.DirectDebitEurobits;
import es.care.sf.scenariosystem.domain.fund.eurobits.FundEurobits;
import es.care.sf.scenariosystem.domain.fundextendedinfo.eurobits.FundExtendedInfoEurobits;
import es.care.sf.scenariosystem.domain.loan.eurobits.LoanEurobits;
import es.care.sf.scenariosystem.domain.pensionplan.eurobits.PensionPlanEurobits;
import es.care.sf.scenariosystem.domain.personalinfo.eurobits.PersonalInfoEurobits;
import es.care.sf.scenariosystem.domain.portfolio.eurobits.PortfolioEurobits;
import es.care.sf.scenariosystem.domain.share.eurobits.ShareEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenarioEurobits {

    private AggregationInfoEurobits aggregationInfo;
    private List<AccountEurobits> accounts = new ArrayList<>();
    private List<DepositEurobits> deposits = new ArrayList<>();
    private List<ShareEurobits> shares = new ArrayList<>();
    private List<FundEurobits> funds = new ArrayList<>();
    private List<LoanEurobits> loans = new ArrayList<>();
    private List<CreditCardEurobits> creditCards = new ArrayList<>();
    private List<DebitCardEurobits> debitCards = new ArrayList<>();
    private List<CreditEurobits> credits = new ArrayList<>();
    private List<AccountHolderEurobits> accountHolders = new ArrayList<>();
    private List<PensionPlanEurobits> pensionPlans = new ArrayList<>();
    private List<PortfolioEurobits> portfolios = new ArrayList<>();
    private List<PersonalInfoEurobits> personalInfo = new ArrayList<>();
    private List<FundExtendedInfoEurobits> fundsExtendedInfo = new ArrayList<>();
    private List<DirectDebitEurobits> directDebits = new ArrayList<>();
}

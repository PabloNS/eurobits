package es.care.sf.scenariosystem.domain.scenario.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.converter.JpaConverterJson;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.aggregationInfo.eurobits.AggregationInfoEurobits;
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

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
public class ScenarioEurobits extends CommonEntity {

    @Id
    private String humanFriendlyName;

    @ManyToOne(cascade = CascadeType.ALL)
    private AggregationInfoEurobits aggregationInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AccountEurobits> accounts = new ArrayList<>();

    @Convert(converter = JpaConverterJson.class)
    private List<DepositEurobits> deposits = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<ShareEurobits> shares = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<FundEurobits> funds = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<LoanEurobits> loans = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<CreditCardEurobits> creditCards = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<DebitCardEurobits> debitCards = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<CreditEurobits> credits = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<AccountHolderEurobits> accountHolders = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<PensionPlanEurobits> pensionPlans = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<PortfolioEurobits> portfolios = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<PersonalInfoEurobits> personalInfo = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<FundExtendedInfoEurobits> fundsExtendedInfo = new ArrayList<>();
    @Convert(converter = JpaConverterJson.class)
    private List<DirectDebitEurobits> directDebits = new ArrayList<>();
}

package es.care.sf.scenariosystem.domain.eurobits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.domain.common.CommonEntity;
import es.care.sf.scenariosystem.domain.common.CommonEntityListener;
import es.care.sf.scenariosystem.domain.eurobits.loyalty.LoyaltyProgram;
import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@EntityListeners(CommonEntityListener.class)
public class ScenarioEurobits extends CommonEntity {


    private boolean twoFactorAuthentication;

    @ManyToOne(cascade = CascadeType.ALL)
    private AggregationInfo aggregationInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SCENARIO_EUROBITS_ACCOUNTS")
    private List<Account> accounts;

    private List<CreditCard> creditCards;
    private List<Deposit> deposits;
    private List<Share> shares;
    private List<Fund> funds;
    private List<Loan> loans;
    private List<AccountHolders> accountHolders;
    private List<PensionPlan> pensionPlans;
    private List<LoyaltyProgram> loyaltyPrograms;
}

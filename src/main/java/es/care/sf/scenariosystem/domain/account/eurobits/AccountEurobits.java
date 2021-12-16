package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.converter.MoneyEurobitsConverter;
import es.care.sf.scenariosystem.domain.MoneyEurobits;
import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
public class AccountEurobits extends CommonEntity {

    private String bank;
    private String branch;
    private String controlDigits;
    private String account;
    @Convert(converter = MoneyEurobitsConverter.class)
    private MoneyEurobits balance;
    private String webAlias;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ACCOUNT_EUROBITS_TRANSACTIONS")
    private List<AccountTransactionEurobits> transactions;

    @JoinTable(name = "SCENARIO_EUROBITS_ACCOUNTS")
    private List<ScenarioEurobits> scenarios;
}

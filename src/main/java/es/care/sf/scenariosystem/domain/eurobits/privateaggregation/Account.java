package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.converter.MoneyConverter;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Entity
@EntityListeners(CommonEntityListener.class)
public class Account extends CommonEntity {

    private String bank;
    private String branch;
    private String controlDigits;
    private String account;
    private String webAlias;

    @Convert(converter = MoneyConverter.class)
    private Money balance;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ACCOUNT_TRANSACTIONS")
    private List<Transaction> transactions;

    @JoinTable(name = "SCENARIO_EUROBITS_ACCOUNTS")
    private List<ScenarioEurobits> scenarios;
}

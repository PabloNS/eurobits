package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.converter.MoneyEurobitsConverter;
import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinTable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
@Builder
public class AccountTransactionEurobits extends CommonEntity {

    private String transactionType;
    private String operationDate;
    private String valueDate;
    private String description;
    @Convert(converter = MoneyEurobitsConverter.class)
    private MoneyEurobits amount;
    private String reference;
    private String payer;
    private String payee;
    @Convert(converter = MoneyEurobitsConverter.class)
    private MoneyEurobits balance;

    //@JoinTable(name = "ACCOUNT_EUROBITS_TRANSACTIONS")
    //private List<AccountEurobits> accounts;
}

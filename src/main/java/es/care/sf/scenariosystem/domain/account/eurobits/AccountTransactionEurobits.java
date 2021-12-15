package es.care.sf.scenariosystem.domain.account.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
public class AccountTransactionEurobits extends CommonEntity {

    @Id
    private String humanFriendlyName;

    private String transactionType;
    private String operationDate;
    private String valueDate;
    private String description;
    private MoneyEurobits amount;
    private String reference;
    private String payer;
    private String payee;
    private MoneyEurobits balance;
}

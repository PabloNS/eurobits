package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.domain.common.CommonEntity;
import es.care.sf.scenariosystem.domain.common.CommonEntityListener;
import es.care.sf.scenariosystem.converter.MoneyConverter;
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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Entity
@EntityListeners(CommonEntityListener.class)
public class  Transaction extends CommonEntity {

    private String operationDate;
    private String valueDate;

    private String description;
    @Convert(converter = MoneyConverter.class)
    private Money amount;

    @Convert(converter = MoneyConverter.class)
    private Money balance;

    private String reference;
    private String payer;
    private String payee;
    private String transactionType;
    private String comments;

    @JoinTable(name = "ACCOUNT_TRANSACTIONS")
    private List<Account> accounts;
}

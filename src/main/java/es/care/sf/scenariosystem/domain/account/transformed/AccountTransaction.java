package es.care.sf.scenariosystem.domain.account.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransaction {

    private Double quantity;
    private Double relativeBalance;
    private Long operationDate;
    private Long valueDate;
    private String description;
    private String reference;
    private String payee;
    private String payer;
    private String transactionType;
}

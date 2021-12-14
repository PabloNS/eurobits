package es.care.sf.scenariosystem.domain.debitcard.eurobits.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardTransaction {

    private String transactionType;
    private String valueDate;
    private String description;
    private MoneyEurobits amount;
    private String comments;
    private String location;
}

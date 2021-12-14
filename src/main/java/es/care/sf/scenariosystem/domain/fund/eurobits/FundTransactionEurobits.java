package es.care.sf.scenariosystem.domain.fund.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransactionEurobits {

    private String operationType;
    private String operationDescription;
    private String operationDate;
    private String fundName;
    private Double quantity;
    //TODO MoneyEurobits type in API doc
    private Double unitPrice;
    private MoneyEurobits operationAmount;
}

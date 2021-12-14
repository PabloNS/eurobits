package es.care.sf.scenariosystem.domain.share.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareTransactionEurobits {

    private String operationType;
    private String operationDescription;
    private String market;
    private String name;
    private String operationDate;
    private String quantity;
    private MoneyEurobits unitPrice;
    private MoneyEurobits amount;
}

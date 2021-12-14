package es.care.sf.scenariosystem.domain.pensionplan.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionPlanTransactionEurobits {

    private String operationType;
    private String operationDescription;
    private String operationDate;
    private MoneyEurobits amount;
    private Double quantity;
    private Double unitPrice;
}

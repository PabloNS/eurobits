package es.care.sf.scenariosystem.domain.loan.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRateEurobits {

    private String interest;
    private String referenceIndex;
    private String margin;
    private String totalCancellation;
    private String partialCancellation;
}

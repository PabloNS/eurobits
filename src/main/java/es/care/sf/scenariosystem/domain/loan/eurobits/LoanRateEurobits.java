package es.care.sf.scenariosystem.domain.loan.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRateEurobits {

    private Double interest;
    private String referenceIndex;
    private Double margin;
    private Double totalCancellation;
    private Double partialCancellation;
}

package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {

    private String accountNumber;
    private String accountType;
    private String branch;
    private String controlDigits;
    private Money debt;
    private Money initialBalance;
    private LoanRates loanRates;
    private Duration period;
    private Money repayment;
    private String repaymentDate;
    private String revisionDate;
    private String webAlias;

}

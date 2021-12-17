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
public class Fund {

    private String accountNumber;
    private Money balance;
    private String branch;
    private String controlDigits;
    private String fundName;
    private String performance;
    private String performanceDescription;
    private String quantity;
    private String valueDate;
    private String webAlias;
    private Money yield;
    private String number;
}

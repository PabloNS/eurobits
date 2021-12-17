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
public class Deposit {

    private String accountNumber;
    private Money balance;
    private String bank;
    private String branch;
    private String controlDigits;
    private Duration duration;
    private Interest interest;
    private String number;
    private String webAlias;


}

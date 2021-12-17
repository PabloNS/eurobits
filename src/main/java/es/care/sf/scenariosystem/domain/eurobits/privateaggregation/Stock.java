package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Stock {

    private String market;
    private String name;
    private Double quantity;
    private Money unitPrice;
    private String valuationDate;

}

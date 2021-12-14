package es.care.sf.scenariosystem.domain.deposit.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestEurobits {

    private Double rate;
    private String type;
}

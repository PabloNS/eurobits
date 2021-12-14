package es.care.sf.scenariosystem.domain.deposit.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestEurobits {

    private String rate;
    private String type;
}

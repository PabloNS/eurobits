package es.care.sf.scenariosystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyEurobits {

    private String amount;
    private String currency;
}

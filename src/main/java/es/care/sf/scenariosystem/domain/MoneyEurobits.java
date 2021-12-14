package es.care.sf.scenariosystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyEurobits {

    private Double amount;
    private String currency;
}

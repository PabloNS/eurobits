package es.care.sf.scenariosystem.domain.fundextendedinfo.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitPrice {

    private String amount;
    private String currency;
    private String valueDate;
}

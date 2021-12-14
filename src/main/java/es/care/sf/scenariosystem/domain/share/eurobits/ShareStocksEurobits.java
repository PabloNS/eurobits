package es.care.sf.scenariosystem.domain.share.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareStocksEurobits {

    private String name;
    private String quantity;
    private MoneyEurobits unitPrice;
    private String valuationDate;
    private String market;
}

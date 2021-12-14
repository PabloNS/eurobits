package es.care.sf.scenariosystem.domain.fundextendedinfo.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundExtendedInfoEurobits {

    private String bank;
    private String branch;
    private String accountNumber;
    private String controlDigits;
    private String number;
    private String fundName;
    private String webAlias;
    private String ISIN;
    private String category;
    private UnitPrice unitPrice;
}

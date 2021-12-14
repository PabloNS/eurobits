package es.care.sf.scenariosystem.domain.share.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareEurobits {

    private String accountNumber;
    private String webAlias;
    private MoneyEurobits balance;
    private List<ShareTransactionEurobits> transactions;
    private List<ShareStocksEurobits> stocks;
}

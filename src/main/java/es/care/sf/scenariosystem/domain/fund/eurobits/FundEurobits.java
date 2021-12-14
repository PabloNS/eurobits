package es.care.sf.scenariosystem.domain.fund.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundEurobits {

    private String bank;
    private String branch;
    private String controlDigits;
    private String accountNumber;
    private String number;
    private MoneyEurobits balance;
    private String webAlias;
    private String fundName;
    private String valueDate;
    private String performance;
    private String performanceDescription;
    private MoneyEurobits yield;
    private String quantity;
    private List<FundTransactionEurobits> transactions;
}

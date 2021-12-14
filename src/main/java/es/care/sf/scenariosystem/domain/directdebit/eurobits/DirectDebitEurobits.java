package es.care.sf.scenariosystem.domain.directdebit.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectDebitEurobits {

    private String IBAN;
    private String bank;
    private String branch;
    private String account;
    private String controlDigits;
    private List<DebitEurobits> debits;
}

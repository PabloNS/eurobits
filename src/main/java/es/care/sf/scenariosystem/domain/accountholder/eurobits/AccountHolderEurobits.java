package es.care.sf.scenariosystem.domain.accountholder.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderEurobits {

    private String bank;
    private String branch;
    private String accountNumber;
    private String controlDigits;
    private List<HolderEurobits> holders;
}

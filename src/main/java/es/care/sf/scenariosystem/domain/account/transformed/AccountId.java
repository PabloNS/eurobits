package es.care.sf.scenariosystem.domain.account.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountId {

    private String bank;
    private String branch;
    private String controlDigits;
    private String number;
    private String accountId;
}

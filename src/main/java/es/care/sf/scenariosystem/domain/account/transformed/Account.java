package es.care.sf.scenariosystem.domain.account.transformed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String ccc;
    private AccountId accountId;
    private Double balance;
    private String alias;
    private String currency;
    private List<AccountTransaction> accountTransactions = new ArrayList<>();
}

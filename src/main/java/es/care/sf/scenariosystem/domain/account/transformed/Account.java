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
@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ccc;

    @OneToOne
    private AccountId accountId;

    private Float balance;
    private String alias;
    private String currency;

    @OneToMany
    private List<AccountTransaction> accountTransactions = new ArrayList<>();
}

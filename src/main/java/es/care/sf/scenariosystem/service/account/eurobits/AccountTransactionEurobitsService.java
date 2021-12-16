package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountTransactionEurobits;
import es.care.sf.scenariosystem.repository.AccountTransactionEurobitsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionEurobitsService {

    private AccountTransactionEurobitsRepository accountTransactionEurobitsRepository;

    public AccountTransactionEurobitsService(AccountTransactionEurobitsRepository accountTransactionEurobitsRepository){
        this.accountTransactionEurobitsRepository = accountTransactionEurobitsRepository;
    }

    public AccountTransactionEurobits createAccountTransaction(AccountTransactionEurobits accountTransactionEurobits) {
        return accountTransactionEurobitsRepository.save(accountTransactionEurobits);
    }
}

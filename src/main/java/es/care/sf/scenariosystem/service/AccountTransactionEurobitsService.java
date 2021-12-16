package es.care.sf.scenariosystem.service;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountTransactionEurobits;
import es.care.sf.scenariosystem.repository.AccountTransactionEurobitsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionEurobitsService {

    private AccountTransactionEurobitsRepository accountTransactionEurobitsRepository;

    public AccountTransactionEurobitsService(AccountTransactionEurobitsRepository accountTransactionEurobitsRepository){
        this.accountTransactionEurobitsRepository = accountTransactionEurobitsRepository;
    }

    public void createAccountTransaction(AccountTransactionEurobits accountTransactionEurobits) {
        accountTransactionEurobitsRepository.save(accountTransactionEurobits);
    }
}

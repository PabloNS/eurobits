package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Account;
import es.care.sf.scenariosystem.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}

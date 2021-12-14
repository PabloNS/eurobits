package es.care.sf.scenariosystem.service;

import es.care.sf.scenariosystem.domain.account.transformed.Account;
import es.care.sf.scenariosystem.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void saveAccount(Account account){
        accountRepository.save(account);
    }
}

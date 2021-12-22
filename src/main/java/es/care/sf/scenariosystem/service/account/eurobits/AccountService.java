package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Account;
import es.care.sf.scenariosystem.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService {

    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}

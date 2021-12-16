package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.repository.AccountEurobitsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountEurobitsService {

    private AccountEurobitsRepository accountEurobitsRepository;

    public AccountEurobitsService(AccountEurobitsRepository accountEurobitsRepository){
        this.accountEurobitsRepository = accountEurobitsRepository;
    }

    public AccountEurobits createAccount(AccountEurobits accountEurobits) {
        return accountEurobitsRepository.save(accountEurobits);
    }
}

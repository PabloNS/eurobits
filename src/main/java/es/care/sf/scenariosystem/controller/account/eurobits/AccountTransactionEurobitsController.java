package es.care.sf.scenariosystem.controller.account.eurobits;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountTransactionEurobits;
import es.care.sf.scenariosystem.service.AccountEurobitsService;
import es.care.sf.scenariosystem.service.AccountTransactionEurobitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accountTransaction/eurobits")
public class AccountTransactionEurobitsController {

    private AccountTransactionEurobitsService accountTransactionEurobitsService;

    public AccountTransactionEurobitsController(AccountTransactionEurobitsService accountTransactionEurobitsService){
        this.accountTransactionEurobitsService = accountTransactionEurobitsService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountTransactionEurobits accountTransactionEurobits){
        return new ResponseEntity(accountTransactionEurobitsService
                .createAccountTransaction(accountTransactionEurobits), HttpStatus.OK);
    }
}

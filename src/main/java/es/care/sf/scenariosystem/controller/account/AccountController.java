package es.care.sf.scenariosystem.controller.account;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Account;
import es.care.sf.scenariosystem.service.account.eurobits.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account/eurobits")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account){
        return new ResponseEntity( accountService.createAccount(account), HttpStatus.OK);
    }
}

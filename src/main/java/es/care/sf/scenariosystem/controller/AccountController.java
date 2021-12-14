package es.care.sf.scenariosystem.controller;

import es.care.sf.scenariosystem.domain.account.transformed.Account;
import es.care.sf.scenariosystem.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account){
        accountService.saveAccount(account);
        return new ResponseEntity(HttpStatus.OK);
    }
}

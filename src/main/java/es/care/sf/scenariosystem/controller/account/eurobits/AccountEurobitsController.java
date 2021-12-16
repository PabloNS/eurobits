package es.care.sf.scenariosystem.controller.account.eurobits;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.service.account.eurobits.AccountEurobitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account/eurobits")
public class AccountEurobitsController {

    private AccountEurobitsService accountEurobitsService;

    public AccountEurobitsController(AccountEurobitsService accountEurobitsService){
        this.accountEurobitsService = accountEurobitsService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody AccountEurobits accountEurobits){
        return new ResponseEntity( accountEurobitsService.createAccount(accountEurobits), HttpStatus.OK);
    }
}

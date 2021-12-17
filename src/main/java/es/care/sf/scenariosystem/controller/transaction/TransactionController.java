package es.care.sf.scenariosystem.controller.transaction;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Transaction;
import es.care.sf.scenariosystem.service.account.eurobits.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accountTransaction/eurobits")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Transaction transaction){
        return new ResponseEntity(transactionService
                .createTransaction(transaction), HttpStatus.OK);
    }
}

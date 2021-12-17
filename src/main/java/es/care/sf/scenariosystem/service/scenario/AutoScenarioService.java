package es.care.sf.scenariosystem.service.scenario;

import es.care.sf.scenariosystem.domain.eurobits.AutoScenarioDto;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Account;
import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Money;
import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Transaction;
import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class AutoScenarioService {

    private ScenarioService scenarioService;

    private UserService userService;

    public AutoScenarioService(UserService userService, ScenarioService scenarioService){
        this.userService = userService;
        this.scenarioService = scenarioService;
    }

    private String generateRandomString(){
        return UUID.randomUUID().toString();
    }

    private Money generateRandomMoney(){
        return Money.builder().amount(Double.valueOf(new Random().nextInt(1000 - 0 + 1) + 0))
                .currency("EUR").build();
    }

    private List<Account> generateRandomAccounts(int numberAccounts){
        List<Account> account = new ArrayList<>();
        for(int i=0; i<numberAccounts; i++){
            account.add(generateRandomAccount(i));
        }
        return account;
    }

    private Account generateRandomAccount(int nAccount){
        Account account = Account.builder()
                .account(generateRandomString())
                .balance(generateRandomMoney())
                .controlDigits("")
                .transactions(generateRandomTransactions(1))
                .bank("")
                .branch("")
                .webAlias("")
                .build();

        account.setHumanFriendlyName("ACCOUNT"
                + (nAccount+1)
                + "-"
                + account.getTransactions().size() + "TRANSACTIONS");

        return account;
    }

    private List<Transaction> generateRandomTransactions(int numberTransactions){
        List<Transaction> transactions = new ArrayList<>();
        for(int i=0; i<numberTransactions; i++){
            transactions.add(generateRandomTransaction());
        }
        return transactions;
    }

    private Transaction generateRandomTransaction(){
        Transaction transaction = Transaction.builder()
                .amount(generateRandomMoney())
                .balance(generateRandomMoney())
                .transactionType("")
                .description("")
                .operationDate(generateRandomDate())
                .payee("")
                .payer("")
                .reference("")
                .valueDate(generateRandomDate())
                .build();
        transaction.setHumanFriendlyName("TRANSACTION-"
                + transaction.getBalance().getAmount()
                + transaction.getBalance().getCurrency());

        return transaction;
    }

    private String generateRandomDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/M/yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public ScenarioEurobits createAutoScenario(AutoScenarioDto autoScenarioDto) {
        ScenarioEurobits scenarioEurobits = new ScenarioEurobits();

        User user = new User();

        scenarioEurobits.setAccounts(generateRandomAccounts(autoScenarioDto.getNumberOfAccounts()));
        scenarioEurobits.setHumanFriendlyName("SCENARIO-AUTO-" + scenarioEurobits.getAccounts().size() + "ACCOUNTS");
        //scenarioEurobits.setAggregationInfo();

        ScenarioEurobits scenario = scenarioService.createScenario(scenarioEurobits);

        user.setScenarioEurobitsId(scenarioEurobits.getHumanFriendlyName());
        userService.createUser(user);

        return scenario;
    }
}

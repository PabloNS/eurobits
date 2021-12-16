package es.care.sf.scenariosystem.service.scenario;

import es.care.sf.scenariosystem.controller.scenario.AutoScenarioDto;
import es.care.sf.scenariosystem.domain.MoneyEurobits;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountTransactionEurobits;
import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
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

    private MoneyEurobits generateRandomMoney(){
        return MoneyEurobits.builder().amount(Double.valueOf(new Random().nextInt(1000 - 0 + 1) + 0))
                .currency("EUR").build();
    }

    private List<AccountEurobits> generateRandomAccounts(int numberAccounts){
        List<AccountEurobits> accountEurobits = new ArrayList<>();
        for(int i=0; i<numberAccounts; i++){
            accountEurobits.add(generateRandomAccount(i));
        }
        return accountEurobits;
    }

    private AccountEurobits generateRandomAccount(int nAccount){
        AccountEurobits accountEurobits = AccountEurobits.builder()
                .account(generateRandomString())
                .balance(generateRandomMoney())
                .controlDigits("")
                .transactions(generateRandomAccountTransactions(1))
                .bank("")
                .branch("")
                .webAlias("")
                .build();

        accountEurobits.setHumanFriendlyName("ACCOUNT"
                + (nAccount+1)
                + "-"
                + accountEurobits.getTransactions().size() + "TRANSACTIONS");

        return accountEurobits;
    }

    private List<AccountTransactionEurobits> generateRandomAccountTransactions(int numberTransactions){
        List<AccountTransactionEurobits> accountTransactionEurobits = new ArrayList<>();
        for(int i=0; i<numberTransactions; i++){
            accountTransactionEurobits.add(generateRandomAccountTransaction());
        }
        return accountTransactionEurobits;
    }

    private AccountTransactionEurobits generateRandomAccountTransaction(){
        AccountTransactionEurobits accountTransactionEurobits = AccountTransactionEurobits.builder()
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
        accountTransactionEurobits.setHumanFriendlyName("ACCOUNT-TRANSACTION-"
                + accountTransactionEurobits.getBalance().getAmount()
                + accountTransactionEurobits.getBalance().getCurrency());

        return accountTransactionEurobits;
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

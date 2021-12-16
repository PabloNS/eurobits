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
        return MoneyEurobits.builder().amount(Double.valueOf(new Random().nextInt(9 - 0 + 1) + 0))
                .currency("EUR").build();
    }

    private List<AccountEurobits> generateRandomAccounts(int numberAccounts){
        List<AccountEurobits> accountEurobits = new ArrayList<>();
        for(int i=0; i<numberAccounts; i++){
            accountEurobits.add(generateRandomAccount());
        }
        return accountEurobits;
    }

    private AccountEurobits generateRandomAccount(){
        return AccountEurobits.builder()
                .account(generateRandomString())
                .balance(generateRandomMoney())
                .controlDigits(generateRandomString())
                .transactions(generateRandomAccountTransactions(1))
                .bank(generateRandomString())
                .branch(generateRandomString())
                .webAlias(generateRandomString())
                .build();
    }

    private List<AccountTransactionEurobits> generateRandomAccountTransactions(int numberTransactions){
        List<AccountTransactionEurobits> accountTransactionEurobits = new ArrayList<>();
        for(int i=0; i<numberTransactions; i++){
            accountTransactionEurobits.add(generateRandomAccountTransaction());
        }
        return accountTransactionEurobits;
    }

    private AccountTransactionEurobits generateRandomAccountTransaction(){
        return AccountTransactionEurobits.builder()
                .amount(generateRandomMoney())
                .balance(generateRandomMoney())
                .transactionType(generateRandomString())
                .description(generateRandomString())
                .operationDate(generateRandomDate())
                .payee(generateRandomString())
                .payer(generateRandomString())
                .reference(generateRandomString())
                .valueDate(generateRandomDate())
                .build();
    }

    private String generateRandomDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public ScenarioEurobits createAutoScenario(AutoScenarioDto autoScenarioDto) {
        ScenarioEurobits scenarioEurobits = new ScenarioEurobits();

        User user = new User();

        scenarioEurobits.setAccounts(generateRandomAccounts(autoScenarioDto.getNumberOfAccounts()));
        scenarioEurobits.setHumanFriendlyName("SCENARIO-" + scenarioEurobits.getAccounts().size() + "-ACCOUNTS");
        //scenarioEurobits.setAggregationInfo();

        ScenarioEurobits scenario = scenarioService.createScenario(scenarioEurobits);

        user.setScenarioEurobitsId(scenarioEurobits.getHumanFriendlyName());
        userService.createUser(user);

        return scenario;
    }
}

package es.care.sf.scenariosystem.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.domain.scenario.transformed.Scenario;
import es.care.sf.scenariosystem.domain.account.transformed.Account;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.account.eurobits.AggregationInfoEurobits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class ScenarioService {

    private Account getAccountTransformed() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Account> typeReference = new TypeReference<>(){};
        InputStream userAsStream = getClass().getResourceAsStream("/transformed/account.json");
        try {
            Account account = mapper.readValue(userAsStream,typeReference);
            return account;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    private AccountEurobits getAccountEurobits() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<AccountEurobits> typeReference = new TypeReference<>(){};
        InputStream userAsStream = getClass().getResourceAsStream("/eurobits/accountEurobits.json");
        try {
            AccountEurobits account = mapper.readValue(userAsStream,typeReference);
            return account;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    private AggregationInfoEurobits getAggregationInfoEurobits() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<AggregationInfoEurobits> typeReference = new TypeReference<>(){};
        InputStream userAsStream = getClass().getResourceAsStream("/eurobits/aggregationInfoEurobits.json");
        try {
            AggregationInfoEurobits aggregationInfoEurobits = mapper.readValue(userAsStream,typeReference);
            return aggregationInfoEurobits;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public ScenarioEurobits getCustomizedScenarioEurobits(int nAccounts) throws IOException {
        ScenarioEurobits scenario = new ScenarioEurobits();
        scenario.setAggregationInfo(getAggregationInfoEurobits());
        for(int i=0; i<nAccounts; i++){
           scenario.getAccounts().add(getAccountEurobits());
        }
        return scenario;
    }

    public Scenario getCustomizedScenarioTransformed(int nAccounts) throws IOException {
        Scenario scenario = new Scenario();
        for(int i=0; i<nAccounts; i++){
            scenario.getResponse().getBankExtract().getAccounts().add(getAccountTransformed());
        }
        return scenario;
    }

    public Scenario getDemoBankScenario() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Scenario> typeReference = new TypeReference<>(){};
        InputStream userAsStream = getClass().getResourceAsStream("/transformed/demoBank.json");
        try {
            Scenario scenario = mapper.readValue(userAsStream,typeReference);
            return scenario;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public ScenarioEurobits getFullExampleEurobitsScenario(int number) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ScenarioEurobits> typeReference = new TypeReference<>(){};
        InputStream userAsStream = getClass().getResourceAsStream("/eurobits/fullExampleEurobits" + number
                + ".json");
        try {
            ScenarioEurobits scenario = mapper.readValue(userAsStream,typeReference);
            return scenario;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public void createScenario(){

    }
}

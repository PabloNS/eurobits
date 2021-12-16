package es.care.sf.scenariosystem.service.scenario;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.care.sf.scenariosystem.domain.account.eurobits.AccountEurobits;
import es.care.sf.scenariosystem.domain.account.transformed.Account;
import es.care.sf.scenariosystem.domain.aggregationInfo.eurobits.AggregationInfoEurobits;
import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.domain.scenario.transformed.Scenario;
import es.care.sf.scenariosystem.repository.ScenarioEurobitsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class ScenarioService {

    private ScenarioEurobitsRepository scenarioEurobitsRepository;

    public ScenarioService(ScenarioEurobitsRepository scenarioEurobitsRepository){
        this.scenarioEurobitsRepository = scenarioEurobitsRepository;
    }

    public Scenario getDemoBankScenario() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Scenario> typeReference = new TypeReference<>(){};
        InputStream resourceAsStream = getResourceAsStream("/transformed/demoBank.json");
        try {
            Scenario scenario = mapper.readValue(resourceAsStream,typeReference);
            return scenario;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public ScenarioEurobits getExampleScenarioEurobits(int number) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ScenarioEurobits> typeReference = new TypeReference<>(){};
        StringBuilder resourcePath = new StringBuilder("/eurobits/fullExampleEurobits").append(number).append(".json");
        InputStream resourceAsStream = getResourceAsStream(resourcePath.toString());
        try {
            ScenarioEurobits scenario = mapper.readValue(resourceAsStream,typeReference);
            return scenario;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public ScenarioEurobits getErrorScenarioEurobits(String errorCode) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ScenarioEurobits> typeReference = new TypeReference<>(){};
        StringBuilder resourcePath = new StringBuilder("/eurobits/errors/").append(errorCode).append(".json");
        InputStream resourceAsStream = getResourceAsStream(resourcePath.toString());
        try {
            ScenarioEurobits scenario = mapper.readValue(resourceAsStream,typeReference);
            /*Long existingSavedScenario = scenarioEurobitsRepository
                    .countByHumanFriendlyName(resourcePath.toString());
            if(existingSavedScenario>0){
                log.error("Scenario {} already exists", resourcePath);
            }
            scenarioEurobitsRepository.save(scenario);*/
            return scenario;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    public ScenarioEurobits createScenario(ScenarioEurobits scenarioEurobits){
        return scenarioEurobitsRepository.save(scenarioEurobits);
    }

    public ScenarioEurobits getScenario(String humanFriendlyName) {
        return scenarioEurobitsRepository.findByHumanFriendlyName(humanFriendlyName);
    }

    private Account getAccountTransformed() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Account> typeReference = new TypeReference<>(){};
        InputStream resourceAsStream = getResourceAsStream("/transformed/account.json");
        try {
            Account account = mapper.readValue(resourceAsStream,typeReference);
            return account;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    private AccountEurobits getAccountEurobits() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<AccountEurobits> typeReference = new TypeReference<>(){};
        InputStream resourceAsStream = getResourceAsStream("/eurobits/accountEurobits.json");
        try {
            AccountEurobits account = mapper.readValue(resourceAsStream,typeReference);
            return account;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    private AggregationInfoEurobits getAggregationInfoEurobits() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<AggregationInfoEurobits> typeReference = new TypeReference<>(){};
        InputStream resourceAsStream = getResourceAsStream("/eurobits/aggregationInfoEurobits.json");
        try {
            AggregationInfoEurobits aggregationInfoEurobits = mapper.readValue(resourceAsStream,typeReference);
            return aggregationInfoEurobits;
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

    private InputStream getResourceAsStream(String resourcePath) throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream(resourcePath);
        if(resourceAsStream==null){
            log.error("Resource with path {} not found", resourcePath);
            StringBuilder exceptionMessage = new StringBuilder("Resource with path ").append(resourcePath)
                    .append(" not found");
            throw new Exception(exceptionMessage.toString());
        }
        return resourceAsStream;
    }

    public List<ScenarioEurobits> getAllScenarios() {
        return scenarioEurobitsRepository.findAll();
    }
}

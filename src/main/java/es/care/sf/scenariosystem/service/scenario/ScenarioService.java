package es.care.sf.scenariosystem.service.scenario;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.care.sf.scenariosystem.domain.eurobits.AggregationRequest;
import es.care.sf.scenariosystem.domain.eurobits.AggregationStatusResponse;
import es.care.sf.scenariosystem.domain.execution.Execution;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.ExecutionRepository;
import es.care.sf.scenariosystem.repository.ScenarioEurobitsRepository;
import es.care.sf.scenariosystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ScenarioService {

    private ScenarioEurobitsRepository scenarioEurobitsRepository;

    private UserService userService;

    private ExecutionRepository executionRepository;

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

    public ScenarioEurobits createScenario(ScenarioEurobits scenarioEurobits){
        return scenarioEurobitsRepository.save(scenarioEurobits);
    }

    public ScenarioEurobits getScenario(String humanFriendlyName) {
        ScenarioEurobits scenarioEurobits = scenarioEurobitsRepository
                .findByHumanFriendlyName(humanFriendlyName);
        if(scenarioEurobits==null){
            log.error("ScenarioEurobits with id {} not found", humanFriendlyName);
            StringBuilder exceptionMessage = new StringBuilder("ScenarioEurobits with id ").append(humanFriendlyName)
                    .append(" not found");
            throw new CustomException(exceptionMessage.toString());
        }
        return scenarioEurobits;
    }

    public List<ScenarioEurobits> getAllScenarios() {
        return scenarioEurobitsRepository.findAll();
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

    public AggregationStatusResponse newAggregation(AggregationRequest aggregationRequest) throws CustomException {
        User user = userService.getUser(Long.valueOf(aggregationRequest.getUserId()));
        ScenarioEurobits scenarioEurobits = getScenario(user.getScenarioEurobitsId());
        Execution execution = Execution.builder().scenarioEurobits(scenarioEurobits)
                .blokedByTwoFactorAuthentication(scenarioEurobits.isTwoFactorAuthentication())
                .build();
        executionRepository.save(execution);
        return AggregationStatusResponse.builder()
                .executionId(String.valueOf(execution.getId())).build();
    }

    public void deleteScenario(String humanFriendlyName) {
        ScenarioEurobits scenarioEurobits = getScenario(humanFriendlyName);
        scenarioEurobitsRepository.delete(scenarioEurobits);
    }
}

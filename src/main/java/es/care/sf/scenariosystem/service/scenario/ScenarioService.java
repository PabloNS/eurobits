package es.care.sf.scenariosystem.service.scenario;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.care.sf.scenariosystem.domain.eurobits.AggregationRequest;
import es.care.sf.scenariosystem.domain.eurobits.AggregationStatusResponse;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.domain.user.User;
import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.ScenarioEurobitsRepository;
import es.care.sf.scenariosystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ScenarioService {

    private ScenarioEurobitsRepository scenarioEurobitsRepository;

    private UserService userService;

    public ScenarioService(ScenarioEurobitsRepository scenarioEurobitsRepository,
                           UserService userService){
        this.scenarioEurobitsRepository = scenarioEurobitsRepository;
        this.userService = userService;
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
            scenarioEurobitsRepository.save(scenario);
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
        return AggregationStatusResponse.builder()
                .executionId(user.getScenarioEurobitsId()).build();
    }
}

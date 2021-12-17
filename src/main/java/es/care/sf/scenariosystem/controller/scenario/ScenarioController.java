package es.care.sf.scenariosystem.controller.scenario;

import es.care.sf.scenariosystem.commons.ExceptionResponse;
import es.care.sf.scenariosystem.domain.eurobits.AggregationRequest;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.service.scenario.ScenarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scenario")
@Slf4j
public class ScenarioController {

    private ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService){
        this.scenarioService = scenarioService;
    }

    @GetMapping("eurobits/example/{number}")
    public ResponseEntity getExampleEurobitsScenario(@PathVariable int number){
        try {
            return new ResponseEntity(scenarioService.getExampleScenarioEurobits(number), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("eurobits")
    public ResponseEntity createScenario(@RequestBody ScenarioEurobits scenarioEurobits){
        return new ResponseEntity(scenarioService.createScenario(scenarioEurobits), HttpStatus.OK);
    }

    @GetMapping("eurobits/{humanFriendlyName}")
    public ResponseEntity getScenario(@PathVariable String humanFriendlyName){
        ScenarioEurobits scenarioEurobits = scenarioService.getScenario(humanFriendlyName);
        return new ResponseEntity(scenarioEurobits, HttpStatus.OK);
    }

    @GetMapping("eurobits")
    public ResponseEntity getAllScenarios(){
        List<ScenarioEurobits> scenarioEurobits = scenarioService.getAllScenarios();
        return new ResponseEntity(scenarioEurobits, HttpStatus.OK);
    }

    //This endpoint is the equivalent first Eurobits request where we get the execId
    @PostMapping("eurobits/api/aggregation")
    public ResponseEntity startAggregationScenario(@RequestBody AggregationRequest aggregationRequest){
        try{
            return new ResponseEntity(scenarioService.newAggregation(aggregationRequest), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //This endpoint is the reponse of the Aggregation where executionId
    //is the Scenario identifier for us
    @GetMapping("eurobits/api/aggregation/{scenarioHumanFriendlyName}")
    public ResponseEntity getAggregationScenario(@PathVariable String scenarioHumanFriendlyName){
        ScenarioEurobits scenarioEurobits = scenarioService.getScenario(scenarioHumanFriendlyName);
        return new ResponseEntity(scenarioEurobits, HttpStatus.OK);
    }
}

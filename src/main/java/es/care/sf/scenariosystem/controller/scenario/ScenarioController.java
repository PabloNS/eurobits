package es.care.sf.scenariosystem.controller.scenario;

import es.care.sf.scenariosystem.domain.eurobits.LoginDto;
import es.care.sf.scenariosystem.domain.eurobits.robotinfo.LoginResponse;
import es.care.sf.scenariosystem.exception.ExceptionResponse;
import es.care.sf.scenariosystem.domain.eurobits.AggregationRequest;
import es.care.sf.scenariosystem.domain.eurobits.Unblock2FADto;
import es.care.sf.scenariosystem.domain.execution.Execution;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.service.execution.ExecutionService;
import es.care.sf.scenariosystem.service.scenario.ScenarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scenario")
@Slf4j
@AllArgsConstructor
public class ScenarioController {

    private ScenarioService scenarioService;

    private ExecutionService executionService;

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

    @DeleteMapping("eurobits/{humanFriendlyName}")
    public ResponseEntity deleteScenario(@PathVariable String humanFriendlyName){
        scenarioService.deleteScenario(humanFriendlyName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("eurobits/api/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        return new ResponseEntity(LoginResponse.builder().build(), HttpStatus.OK);
    }

    @PostMapping("eurobits/api/aggregation")
    public ResponseEntity startAggregationScenario(@RequestBody AggregationRequest aggregationRequest){
        try{
            return new ResponseEntity(scenarioService.newAggregation(aggregationRequest), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("eurobits/api/aggregation/{executionId}")
    public ResponseEntity getAggregationScenario(@PathVariable Long executionId){
        Execution execution = executionService.getExecution(executionId);
        return new ResponseEntity(execution.getScenarioEurobits(), execution.getHttpStatus());
    }

    @PutMapping("eurobits/api/aggregation/{executionId}")
    public ResponseEntity unblock2FA(@PathVariable Long executionId,
                                     @RequestBody Unblock2FADto unblock2FADto){
        executionService.unblockTwoFactorAuthentication(executionId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("eurobits/api/aggregation/{executionId}")
    public ResponseEntity unblock2FA(@PathVariable Long executionId){
        executionService.deleteExecution(executionId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

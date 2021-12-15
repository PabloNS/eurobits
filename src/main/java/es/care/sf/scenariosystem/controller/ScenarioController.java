package es.care.sf.scenariosystem.controller;

import es.care.sf.scenariosystem.commons.ExceptionResponse;
import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.service.ScenarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("scenario")
@Slf4j
public class ScenarioController {

    private ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService){
        this.scenarioService = scenarioService;
    }

    @GetMapping("eurobits/custom")
    public ResponseEntity getCustomizedScenarioEurobits(@RequestParam(name = "nAccounts") int nAccounts){
        try {
            return new ResponseEntity(scenarioService.getCustomizedScenarioEurobits(nAccounts), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("transformed/custom")
    public ResponseEntity getCustomizedScenario(@RequestParam(name = "nAccounts") int nAccounts){
        try {
            return new ResponseEntity(scenarioService.getCustomizedScenarioTransformed(nAccounts), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("transformed/demoBank")
    public ResponseEntity getDemoBankScenario(){
        try {
            return new ResponseEntity(scenarioService.getDemoBankScenario(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("eurobits/example/{number}")
    public ResponseEntity getExampleEurobitsScenario(@PathVariable int number){
        try {
            return new ResponseEntity(scenarioService.getExampleScenarioEurobits(number), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("eurobits/error/{errorCode}")
    public ResponseEntity getFullExampleEurobitsScenario(@PathVariable String errorCode){
        try {
            return new ResponseEntity(scenarioService.getErrorScenarioEurobits(errorCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("eurobits")
    public ResponseEntity createScenario(@RequestBody ScenarioEurobits scenarioEurobits){
        scenarioService.createScenario(scenarioEurobits);
        return new ResponseEntity(HttpStatus.OK);
    }
}

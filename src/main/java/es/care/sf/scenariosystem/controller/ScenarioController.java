package es.care.sf.scenariosystem.controller;

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

    @GetMapping("eurobits")
    public ResponseEntity getCustomizedScenarioEurobits(@RequestParam(name = "nAccounts") int nAccounts){
        try {
            return new ResponseEntity(scenarioService.getCustomizedScenarioEurobits(nAccounts), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("transformed")
    public ResponseEntity getCustomizedScenario(@RequestParam(name = "nAccounts") int nAccounts){
        try {
            return new ResponseEntity(scenarioService.getCustomizedScenarioTransformed(nAccounts), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("demoBank")
    public ResponseEntity getDemoBankScenario(){
        try {
            return new ResponseEntity(scenarioService.getDemoBankScenario(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("fullExampleEurobits/{number}")
    public ResponseEntity getFullExampleEurobitsScenario(@PathVariable int number){
        try {
            return new ResponseEntity(scenarioService.getFullExampleEurobitsScenario(number), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity createScenario(){
        scenarioService.createScenario();
        return new ResponseEntity(HttpStatus.OK);
    }
}

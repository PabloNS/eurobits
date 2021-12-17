package es.care.sf.scenariosystem.controller.scenario;

import es.care.sf.scenariosystem.domain.eurobits.AutoScenarioDto;
import es.care.sf.scenariosystem.service.scenario.AutoScenarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scenario/eurobits/auto")
public class AutoScenarioController {

    private AutoScenarioService autoScenarioService;

    public AutoScenarioController(AutoScenarioService autoScenarioService){
        this.autoScenarioService = autoScenarioService;
    }

    @PostMapping
    public ResponseEntity createAutoScenario(@RequestBody AutoScenarioDto autoScenarioDto){
        return new ResponseEntity(autoScenarioService.createAutoScenario(autoScenarioDto), HttpStatus.OK);
    }


}


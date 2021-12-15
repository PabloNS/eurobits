package es.care.sf.scenariosystem.commons;

import es.care.sf.scenariosystem.domain.scenario.eurobits.ScenarioEurobits;
import es.care.sf.scenariosystem.repository.ScenarioEurobitsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import java.util.UUID;

@Component
@Slf4j
public class CommonEntityListener {

    private ScenarioEurobitsRepository scenarioEurobitsRepository;

    @Autowired
    public CommonEntityListener(@Lazy ScenarioEurobitsRepository scenarioEurobitsRepository){
        this.scenarioEurobitsRepository = scenarioEurobitsRepository;
    }

    @PrePersist
    public void prePersist(CommonEntity commonEntity) {
        if(commonEntity.getHumanFriendlyName()==null){
            commonEntity.setHumanFriendlyName(commonEntity.getClass().getSimpleName() + "-" + UUID.randomUUID());
        } else{
            Long existingSavedScenario = scenarioEurobitsRepository
                    .countByHumanFriendlyName(commonEntity.getHumanFriendlyName());
            if(existingSavedScenario>0){
                log.error("Scenario {} already exists", commonEntity.getHumanFriendlyName());
                //scenarioEurobits.setHumanFriendlyName(scenarioEurobits.getHumanFriendlyName() + "_NEW");
            }
        }
    }
}

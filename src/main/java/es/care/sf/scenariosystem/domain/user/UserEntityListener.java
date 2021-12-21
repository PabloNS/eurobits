package es.care.sf.scenariosystem.domain.user;

import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.ScenarioEurobitsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;

@Component
@Slf4j
public class UserEntityListener {

    private ScenarioEurobitsRepository scenarioEurobitsRepository;

    @Autowired
    public UserEntityListener(@Lazy ScenarioEurobitsRepository scenarioEurobitsRepository){
        this.scenarioEurobitsRepository = scenarioEurobitsRepository;
    }

    @PrePersist
    public void prePersist(User user) throws Exception {
        if(user.getScenarioEurobitsId()!=null){
            Long existingSavedScenario = scenarioEurobitsRepository
                    .countByHumanFriendlyName(user.getScenarioEurobitsId());
            if(existingSavedScenario==0){
                log.error("Scenario with id {} doesn't exists", user.getScenarioEurobitsId());
                throw new CustomException("Scenario with id " + user.getScenarioEurobitsId() + " doesn't exists");
            }
        }
    }
}

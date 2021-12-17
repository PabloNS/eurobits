package es.care.sf.scenariosystem.repository;

import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioEurobitsRepository extends JpaRepository<ScenarioEurobits, String> {

    ScenarioEurobits findByHumanFriendlyName(String compositePrimaryKeyHumanFriendlyName);
    Long countByHumanFriendlyName(String compositePrimaryKeyHumanFriendlyName);
}

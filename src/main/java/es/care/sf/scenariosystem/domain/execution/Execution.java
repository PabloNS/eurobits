package es.care.sf.scenariosystem.domain.execution;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.domain.eurobits.ScenarioEurobits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ScenarioEurobits scenarioEurobits;

    private boolean blokedByTwoFactorAuthentication;

    public HttpStatus getHttpStatus() {
        if(blokedByTwoFactorAuthentication){
            return HttpStatus.CONFLICT;
        } else {
            return HttpStatus.OK;
        }
    }
}

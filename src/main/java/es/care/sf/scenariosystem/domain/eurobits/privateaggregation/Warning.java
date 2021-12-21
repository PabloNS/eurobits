package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.domain.common.CommonEntity;
import es.care.sf.scenariosystem.domain.common.CommonEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@EntityListeners(CommonEntityListener.class)
public class Warning extends CommonEntity {
    private String warningCause;
    private String warningDetails;
}

package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@EntityListeners(CommonEntityListener.class)
public class AggregationInfo extends CommonEntity {

    private String code;
    private String message;

    @ManyToMany
    private List<Warning> warnings;
}

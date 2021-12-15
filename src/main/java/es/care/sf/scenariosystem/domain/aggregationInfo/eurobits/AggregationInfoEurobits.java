package es.care.sf.scenariosystem.domain.aggregationInfo.eurobits;

import es.care.sf.scenariosystem.commons.CommonEntity;
import es.care.sf.scenariosystem.commons.CommonEntityListener;
import es.care.sf.scenariosystem.converter.JpaConverterJson;
import es.care.sf.scenariosystem.domain.warning.eurobits.WarningEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(CommonEntityListener.class)
public class AggregationInfoEurobits extends CommonEntity {

    @Id
    private String humanFriendlyName;

    private String code;
    private String message;
    //TODO type?
    @Convert(converter = JpaConverterJson.class)
    private List<String> companies;
    @ManyToMany
    private List<WarningEurobits> warnings;
    private String robotCode;
}

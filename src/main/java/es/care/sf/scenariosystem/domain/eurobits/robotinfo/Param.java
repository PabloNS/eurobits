package es.care.sf.scenariosystem.domain.eurobits.robotinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Param {

    private String defaultValue;
    private List<String> descriptions;
    private String description;
    private Boolean encoded;
    private String name;
    List<ParamValue> paramsValue;
    List<String> plainParams;

    private Boolean required;
    private String type;


}

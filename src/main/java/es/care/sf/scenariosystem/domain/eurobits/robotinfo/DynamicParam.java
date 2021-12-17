package es.care.sf.scenariosystem.domain.eurobits.robotinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DynamicParam {

    private String description;
    private String name;
    private String type;
    private String value;
}

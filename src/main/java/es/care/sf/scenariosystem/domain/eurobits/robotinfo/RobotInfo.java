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
public class RobotInfo {

    private String category;
    private String code;
    private String description;
    private String descriptions;
    private DynamicParam dynamicParam;
    private String name;
    private List<ErrorInfo> robotLoginErrors;
    private List<Param> params;
    private List<Product> products;
}

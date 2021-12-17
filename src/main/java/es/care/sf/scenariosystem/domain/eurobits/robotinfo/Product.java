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
public class Product {

    private String description;
    private List<String> descriptions;
    private String name;
    private List<ErrorInfo> productErrors;
    private List<SubProduct> subProducts;

}
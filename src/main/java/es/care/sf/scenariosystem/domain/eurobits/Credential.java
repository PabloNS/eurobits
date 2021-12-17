package es.care.sf.scenariosystem.domain.eurobits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by rafa on 1/02/17.
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(value= "encrypt",ignoreUnknown = true)
public class Credential {

    private String name;
    private String value;
}
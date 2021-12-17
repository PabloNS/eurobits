package es.care.sf.scenariosystem.domain.eurobits.loyalty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by rafa on 6/02/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Balance {

    Double amount;
    String description;
    String currency;
    List<Expiration> expirations;
    String relatedCardNumber;

}

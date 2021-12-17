package es.care.sf.scenariosystem.domain.eurobits.loyalty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expiration {
    String date;
    String dueBalance;
    String notBefore;
    String reason;
}

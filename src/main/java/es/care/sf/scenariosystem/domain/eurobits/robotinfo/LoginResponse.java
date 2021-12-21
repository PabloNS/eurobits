package es.care.sf.scenariosystem.domain.eurobits.robotinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class LoginResponse {

    private String message;
    private String token;
    private String code;
    private String developerMessage;
    private String moreInfoUrl;
    private String status;


}

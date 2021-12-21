package es.care.sf.scenariosystem.domain.eurobits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String password;
    private String service;
}

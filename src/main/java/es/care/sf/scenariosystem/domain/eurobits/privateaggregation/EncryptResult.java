package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EncryptResult {

    private Boolean encrypted;
    private List<Credential> credentials;
    private String secondPhase;
    private String certificateAlias;

    public Map<String, String> getCredentialsAsMap() {
        final Map<String, String> credentialsMap = new HashMap<>();

        for(Credential credential : credentials) {
            credentialsMap.put(credential.getName(), credential.getValue());
        }

        return credentialsMap;
    }
}

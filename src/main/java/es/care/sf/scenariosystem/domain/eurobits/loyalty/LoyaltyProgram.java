package es.care.sf.scenariosystem.domain.eurobits.loyalty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoyaltyProgram {
    private String catalog;
    private List<Balance> balances;
    private List<Card> cards;
    private List<Member> members;
}

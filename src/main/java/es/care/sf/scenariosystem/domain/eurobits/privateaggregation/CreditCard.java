package es.care.sf.scenariosystem.domain.eurobits.privateaggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {

    private String cardType;
    private String cardNumber;
    private Money limit;
    private Money disposed;
    private Money available;
    private String expirationDate;
    private String paymentDueDate;
    private Money paymentAmount;
    private String billingPeriodStart;
    private String billingPeriodEnd;
    private String webAlias;
    private List<Transaction> transactions;
}

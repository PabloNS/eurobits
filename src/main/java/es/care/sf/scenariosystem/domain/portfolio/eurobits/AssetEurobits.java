package es.care.sf.scenariosystem.domain.portfolio.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetEurobits {

    private String description;
    private String assetNumber;
    private String quantity;
    private String unitPrice;
    private MoneyEurobits value;
    private MoneyEurobits sourceValue;
    private String initialAmount;
    private String performance;
    private String performanceDescription;
    private MoneyEurobits yield;
    private String assetType;
}

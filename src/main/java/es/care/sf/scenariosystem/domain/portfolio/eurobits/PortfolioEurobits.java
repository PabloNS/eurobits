package es.care.sf.scenariosystem.domain.portfolio.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioEurobits {

    private String portfolioNumber;
    private String webAlias;
    private MoneyEurobits balance;
    private String portfolioType;
    private String valueDate;
    private String performanceDescription;
    private String performance;
    private MoneyEurobits yield;
    private List<AssetEurobits> assets;
}

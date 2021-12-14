package es.care.sf.scenariosystem.domain.directdebit.eurobits;

import es.care.sf.scenariosystem.domain.MoneyEurobits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitEurobits {

    private String payeename;
    private String payeeid;
    private String directdebitholder;
    private String status;
    private String startdate;
    private String lastpaymentdate;
    private MoneyEurobits lastpaymentamount;
    private String mandatereference;
    private String payeereference;
    private String contractnumber;
}

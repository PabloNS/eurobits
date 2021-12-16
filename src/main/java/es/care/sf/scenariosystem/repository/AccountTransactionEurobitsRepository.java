package es.care.sf.scenariosystem.repository;

import es.care.sf.scenariosystem.domain.account.eurobits.AccountTransactionEurobits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionEurobitsRepository extends JpaRepository<AccountTransactionEurobits, String> {

}

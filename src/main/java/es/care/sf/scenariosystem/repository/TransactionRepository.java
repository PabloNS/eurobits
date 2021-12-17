package es.care.sf.scenariosystem.repository;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

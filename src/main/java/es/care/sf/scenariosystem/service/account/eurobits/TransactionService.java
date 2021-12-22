package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Transaction;
import es.care.sf.scenariosystem.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionService {

    private TransactionRepository transactionRepositoryRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepositoryRepository.save(transaction);
    }
}

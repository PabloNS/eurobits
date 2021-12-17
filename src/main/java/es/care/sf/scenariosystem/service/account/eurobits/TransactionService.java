package es.care.sf.scenariosystem.service.account.eurobits;

import es.care.sf.scenariosystem.domain.eurobits.privateaggregation.Transaction;
import es.care.sf.scenariosystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private TransactionRepository transactionRepositoryRepository;

    public TransactionService(TransactionRepository transactionRepositoryRepository){
        this.transactionRepositoryRepository = transactionRepositoryRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepositoryRepository.save(transaction);
    }
}

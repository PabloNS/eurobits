package es.care.sf.scenariosystem.service.execution;

import es.care.sf.scenariosystem.domain.execution.Execution;
import es.care.sf.scenariosystem.exception.CustomException;
import es.care.sf.scenariosystem.repository.ExecutionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ExecutionService {

    private ExecutionRepository executionRepository;

    public Execution getExecution(Long executionId) {
        Optional<Execution> execution = executionRepository.findById(Long.valueOf(executionId));
        if(!execution.isPresent()){
            log.error("Execution with id {} not found", executionId);
            StringBuilder exceptionMessage = new StringBuilder("User with id ").append(executionId)
                    .append(" not found");
            throw new CustomException(exceptionMessage.toString());
        }
        return execution.get();
    }

    public void unblockTwoFactorAuthentication(Long executionId) {
        Execution execution = getExecution(executionId);
        execution.setBlokedByTwoFactorAuthentication(false);
        executionRepository.save(execution);
    }

    public void deleteExecution(Long executionId) {
        Execution execution = getExecution(executionId);
        executionRepository.delete(execution);
    }
}

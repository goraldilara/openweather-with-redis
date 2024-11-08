package dg.littleweather.service;

import dg.littleweather.domain.Operation;
import dg.littleweather.repository.OperationRedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    private final OperationRedisRepository operationRedisRepository;

    public OperationService(OperationRedisRepository operationRedisRepository){
        this.operationRedisRepository = operationRedisRepository;
    }

    //create operation
    public Operation saveOperation(Operation operation){
        return operationRedisRepository.save(operation);
    }

    //read operation
    public Operation getOperationById(int id){
        return operationRedisRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find the operation by id: " + id));
    }

    //update operation
    public Operation updateOperation(int id, Operation operation){
        Operation oldOperation = getOperationById(id);
        oldOperation.setOperationType(operation.getOperationType());

        return operationRedisRepository.save(oldOperation);
    }

    //delete operation
    public void deleteOperation(int id){
        Operation operation = getOperationById(id);

        operationRedisRepository.delete(operation) ;
    }

    public List<Operation> getAllOperations() {
        return (List<Operation>) operationRedisRepository.findAll();
    }
}
